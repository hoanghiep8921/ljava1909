package com.example.demo_api_security.repository;

import com.example.demo_api_security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByName(String name);
}
