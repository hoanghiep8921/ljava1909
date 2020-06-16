package com.example.shoppoing.repository;

import com.example.shoppoing.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findByGender(String gender);
}
