package com.example.demo.controller.my;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyInfoController {

    @RequestMapping("/base/info")
    public String log(){
        return "say";
    }



}
