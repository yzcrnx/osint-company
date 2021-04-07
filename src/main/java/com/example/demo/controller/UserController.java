package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String Login(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.get("username").toString();
        String password = jsonObject.get("password").toString();
        String name = userService.Login(username, password);
        return name;
        /*
        if(name != null) {
            return "/main";
        } else {
            return "/login";
        }
         */
    }
}
