package com.example.demoapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/getdata")
    @ResponseBody
    public String getData(){
        return "getdata";
    }
}
