package com.example.shoppoing.controller;

import com.example.shoppoing.model.Product;
import com.example.shoppoing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
@Autowired
    ProductService productService;
    @RequestMapping("/index")
    public String index(Model model){
        List<Product> lstProductWoman = productService.getListProductByGender("nu");
        List<Product> lstProductMan = productService.getListProductByGender("nam");

        model.addAttribute("listProductWoman ",lstProductWoman);
        model.addAttribute("listProductMan", lstProductMan);
        return "index";
    }

}
