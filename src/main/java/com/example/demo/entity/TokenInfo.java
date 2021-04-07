package com.example.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "osint")
@PropertySource("classpath:config/config.properties")
public class TokenInfo {

    public String getFofa_token() {
        return Fofa_token;
    }

    public void setFofa_token(String fofa_token) {
        Fofa_token = fofa_token;
    }

    public String getFofa_mail() {
        return Fofa_mail;
    }

    public void setFofa_mail(String fofa_mail) {
        Fofa_mail = fofa_mail;
    }

    public String getQiXin_cookie() {
        return QiXin_cookie;
    }

    public void setQiXin_cookie(String qiXin_cookie) {
        QiXin_cookie = qiXin_cookie;
    }

    public String getTian_token() {
        return Tian_token;
    }

    public void setTian_token(String tian_token) {
        Tian_token = tian_token;
    }

    public Boolean getTian_Flag() {
        return Tian_Flag;
    }

    public void setTian_Flag(Boolean tian_Flag) {
        Tian_Flag = tian_Flag;
    }

    private String Fofa_token = "";

    private String Fofa_mail = "";

    private String QiXin_cookie = "";

    private String Tian_token = "";

    private Boolean Tian_Flag = true;

}
