package com.example.demo.aop;

import com.example.demo.exception.TokenException;
import com.example.demo.utils.CookieUtils;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CookieAop {

    @Pointcut("execution(* com.example.demo.controller.my..*(..))")
    public void controllerMethodPointcut(){}

    @Before("controllerMethodPointcut()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtils.get(request, "token");
        if(cookie == null){
            throw new TokenException();
        }
        //查询cookie


    }


}
