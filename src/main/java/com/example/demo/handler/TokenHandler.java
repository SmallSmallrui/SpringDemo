package com.example.demo.handler;

import com.example.demo.exception.TokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TokenHandler {


    @ExceptionHandler(TokenException.class)
    public String handlerExcetion(){
        return "您没有登录,请先登录后再访问接口";
    }
}
