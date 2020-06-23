package com.example.demo_api_security.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController {
    @RequestMapping("/403")
    public String accessDenied(){
       return "403";
   }

    @RequestMapping("/getInfoUser")
    public List<String> getInforUser(){
        return Arrays.asList("Name User","ADMIN",
                new Date().toString());
    }


}
