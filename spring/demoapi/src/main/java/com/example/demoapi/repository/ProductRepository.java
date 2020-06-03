package com.example.demoapi.repository;

import com.example.demoapi.model.ProductModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModal,String> {
}
