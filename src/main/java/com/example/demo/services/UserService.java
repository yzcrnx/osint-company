package com.example.demo.services;


import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public String Login(String username,String password) {
        String p1 = MD5Util.getMD5(password);
        UserInfo userInfo = userMapper.Login(username,p1);
        return userInfo.getUsername();
    }
}
