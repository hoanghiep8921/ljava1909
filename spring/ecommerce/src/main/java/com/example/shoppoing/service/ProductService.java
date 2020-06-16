package com.example.shoppoing.service;

import com.example.shoppoing.model.Product;
import com.example.shoppoing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getListProductByGender(String gender){
        List<Product> lstProduct = productRepository.findByGender(gender);
        return lstProduct;
    }
}
