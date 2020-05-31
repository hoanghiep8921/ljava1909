package com.example.demoapi.repository;


import com.example.demoapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username,
                                             String password);
    Optional<User> findByUsername(String username);
}
