package com.example.demo.controller;

import com.example.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value = "/company")
@ResponseBody
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "GetInfo",method = RequestMethod.GET)
    public String GetBaseInfo(@RequestParam String name) {
        String result = String.valueOf(companyService.GetBaseInfo(name));
        return result;
    }

    /*根据公司名获取子公司的名称*/
    @RequestMapping(value = "GetSub", method = RequestMethod.GET)
    public String GetSubCompany(@RequestParam String name) {
        companyService.GetSub(name);
        return name;
    }

    /*根据传入的母公司获取所有子公司的信息*/
    @RequestMapping(value = "GetSubDetail", method = RequestMethod.GET)
    public String GetCompanyDetail(@RequestParam String name) {

        String result = String.valueOf(companyService.GetCompanyDetail(name));
        return result;
    }
}
