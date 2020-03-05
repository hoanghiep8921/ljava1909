package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        Student student = new Student("Hiệp","001",25);
        model.addAttribute("studentModel",student);
        return "hello";
    }
}
