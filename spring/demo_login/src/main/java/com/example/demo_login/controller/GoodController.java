package com.example.demo_login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/good")
public class GoodController {
    @RequestMapping({"/",""})
    public String good(){
        return "Fuck";
    }
}
