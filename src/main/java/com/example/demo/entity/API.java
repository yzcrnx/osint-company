package com.example.demo.entity;


public enum API {
    T819("https://open.tianyancha.com/cloud-open-api/services/open/ic/baseinfoV3/2.0.json?keyword="),
    T823("https://open.tianyancha.com/cloud-open-api/services/open/ic/inverst/2.0.json?pageSize=20&keyword=");

    API(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
}
