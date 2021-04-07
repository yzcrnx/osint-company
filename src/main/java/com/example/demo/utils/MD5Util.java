package com.example.demo.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {
    private static String salt = "123";

    public static String getMD5(String plaintext) {
        String p1 = plaintext + salt;
        String md5 = DigestUtils.md5DigestAsHex(p1.getBytes());
        return md5;
    }
}
