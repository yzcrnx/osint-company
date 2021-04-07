package com.example.demo.mapper;

import com.example.demo.entity.CompanyInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface CompanyMapper {

    public int findCompanyNum(@Param("CompanyName") String CompanyName);

    public void insertCompany(CompanyInfo companyInfo);

    @MapKey("name")
    public Map<String, List<CompanyInfo>> findSubCompany(@Param("CompanyName") String CompanyName);

    public int findSubCompanyNum(@Param("masterCompany") String masterCompany);

    public CompanyInfo findCompany(@Param("CompanyName") String CompanyName);

    public void updateCompanyInfo(CompanyInfo companyInfo);
}
