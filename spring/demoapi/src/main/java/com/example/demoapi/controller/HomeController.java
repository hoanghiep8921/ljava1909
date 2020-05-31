package com.example.demoapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/getdata")
    @ResponseBody
    public String getData(){
        return "getdata";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "form_login";
    }
}
