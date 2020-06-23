package com.example.demo_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
   @RequestMapping("/403")
    public String accessDenied(){
       return "403";
   }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    @RequestMapping("/bye")
    public String goodBye(Model model){
        model.addAttribute("goodBye","GOOD BYE");
        return "bye";
    }
}
