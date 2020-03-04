package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/test/{name}/url/{family}")
    public String test(Model model,
                       @PathVariable String name,
                       @PathVariable String family){
        model.addAttribute("name",name);
        model.addAttribute("family",family);
        return "test";
    }

    @RequestMapping("/testparam")
    public String testParam(Model model,
                            @RequestParam("name") String name,
                            @RequestParam("family") String family){
        model.addAttribute("name",name);
        model.addAttribute("family",family);
        return "test";
    }
}
