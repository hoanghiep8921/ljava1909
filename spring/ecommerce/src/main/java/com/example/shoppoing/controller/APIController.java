package com.example.shoppoing.controller;

import com.example.shoppoing.model.BaseResponse;
import com.example.shoppoing.service.ProductService;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getproduct", method = RequestMethod.GET)
    public BaseResponse getproduct(){
        BaseResponse baserepspon = new BaseResponse();
        baserepspon.setCode("00");
        baserepspon.setData(productService.getListProductByGender("nam"));
        baserepspon.setMessage("lay sp thanh cong");
        return baserepspon;
    }
}
