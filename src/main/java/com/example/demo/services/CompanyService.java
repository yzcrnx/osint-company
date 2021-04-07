package com.example.demo.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.API;
import com.example.demo.entity.CompanyInfo;
import com.example.demo.entity.TokenInfo;
import com.example.demo.mapper.CompanyMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private TokenInfo tokenInfo;

    private JSONObject CompanyInfo = null;

    public JSONObject GetBaseInfo(String name) {
        CompanyInfo = doAPIGet(API.T819.getUrl(),name,1).getJSONObject("result");
        CompanyInfo companyInfo = JSON.parseObject(String.valueOf(CompanyInfo),CompanyInfo.class);
        try{
            int num = companyMapper.findCompanyNum(name);
            String email = companyMapper.findCompany(name).getEmail();
            if(num < 0) {
                companyMapper.insertCompany(companyInfo);
            }else if(num > 0 && email == null) {
                companyMapper.updateCompanyInfo(companyInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GetCompanyDetail(name);
    }

    public JSONObject GetCompanyDetail(String name) {
        CompanyInfo companyInfo = companyMapper.findCompany(name);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(companyInfo);
        return jsonObject;
    }

    public void GetSub(String name) {
        try {
            JSONObject SubInfo = doAPIGet(API.T823.getUrl(),name,1);
            int total = SubInfo.getJSONObject("result").getIntValue("total");
            if(companyMapper.findSubCompanyNum(name) != total) {
                InsertSub(name,total);
                System.out.println("插入/更新成功");
            }
            Map<String,List<CompanyInfo>> companyInfoMap = companyMapper.findSubCompany(name);
            for(String key : companyInfoMap.keySet()) {
                GetBaseInfo(key);
                System.out.println(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void InsertSub(String name, int total) {
        try {
            JSONArray temp = null;
            for(int i =1;i<=(total/20)+1;i++) {
                temp = doAPIGet(API.T823.getUrl(),name,i).getJSONObject("result").getJSONArray("items");
                List<CompanyInfo> companyInfos = JSONObject.parseArray(temp.toJSONString(),CompanyInfo.class);
                for(CompanyInfo companyInfo: companyInfos) {
                    companyInfo.setMasterCompany(name);
                    companyMapper.insertCompany(companyInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("新增对外投资结束");
        }
    }

    private JSONObject doAPIGet(String url, String name, int pageNum){
        CloseableHttpClient httpClient = null;
        JSONObject jsonObject =null;
        try {
            httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url + URLEncoder.encode(name,"UTF-8") + "&pageNum=" + pageNum);
            httpGet.setHeader("Authorization",tokenInfo.getTian_token());
            httpGet.setHeader("Content-Type","application/json");
            RequestConfig resquestConfig =
                    RequestConfig.custom().setConnectTimeout(3000).setConnectionRequestTimeout(3000).setSocketTimeout(6000).build();
            httpGet.setConfig(resquestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            jsonObject = JSON.parseObject(result);
            // api接口请求返回会多一个result的json，去除后返回
            jsonObject = jsonObject.getJSONObject("result");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

}
