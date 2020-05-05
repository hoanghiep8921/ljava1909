package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("/index/{name}")
    public String index(@PathVariable("name") String name,
                        @RequestParam("q") String query,
                        Model model){
        model.addAttribute("name",name);
        model.addAttribute("que",query);
        return "index";
    }

    @RequestMapping(value = "/learn",method = RequestMethod.POST)
    public String learn(@RequestParam("name") String name,
                        @RequestParam("age") int tuoi){
        System.out.println("Teen gui len la :"+name + "- tuoi la :" + tuoi);
      return "learn";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        Student student = new Student("Hiệp","001",25);
        model.addAttribute("studentModel",student);
        return "hello";
    }
}
