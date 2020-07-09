package com.example.democache.controller;

import com.example.democache.model.User;
import com.example.democache.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("id") int id){
        User user = userService.findUserById(id);
        return user;
    }

    @RequestMapping("/clear")
    @ResponseBody
    public void clearAllCache(){
       userService.clearCache();
    }

    @RequestMapping("/clear/{id}")
    @ResponseBody
    public void clearCacheById(@PathVariable("id")int id){
        userService.clearCacheById(id);
    }

    @RequestMapping("/put/{id}")
    @ResponseBody
    public void putById(@PathVariable("id")int id){
        userService.putUserById(id);
    }
}
