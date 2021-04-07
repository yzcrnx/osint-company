package com.example.demo.entity;


import java.io.Serializable;

public class CompanyInfo implements Serializable {

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteList() {
        return websiteList;
    }

    public void setWebsiteList(String websiteList) {
        this.websiteList = websiteList;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMasterCompany() {
        return masterCompany;
    }

    public void setMasterCompany(String masterCompany) {
        this.masterCompany = masterCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    private long id;
    private String phoneNumber;
    private String email;
    private String websiteList;
    private String creditCode;
    private String legalPersonName;
    private String masterCompany;
    private String name;
    private String regStatus;
    private String percent;
}
