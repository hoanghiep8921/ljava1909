package com.example.demoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {

    @RequestMapping(value = "/api/example",method = RequestMethod.GET)
    //@GetMapping("/api/example");
    public int example(){
        return 100;
    }
}
