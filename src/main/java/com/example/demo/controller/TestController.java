package com.example.demo.controller;

import com.example.demo.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {


    @RequestMapping("/test")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam("username") String userName , @RequestParam("password") String password , HttpServletResponse response){
        Cookie cookie = new Cookie("token" , userName);
        cookie.setPath("/");
        cookie.setMaxAge(3);
        CookieUtils.setCookie(cookie);
        response.addCookie(cookie);
        return "欢迎" + userName + "登录";
    }




}
