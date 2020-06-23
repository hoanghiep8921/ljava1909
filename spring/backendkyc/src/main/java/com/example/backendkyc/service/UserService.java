package com.example.backendkyc.service;

import com.example.backendkyc.model.User;
import com.example.backendkyc.reposiroty.UserRepository;
import com.example.backendkyc.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUserName(String userName) {
        User user = null;
        Optional<User> optUser = userRepository.findByUserName(userName);
        if(optUser.isPresent()){
            user = optUser.get();
        }
        return user;
    }

    public List<User> findUser(User user, String fromDate, String toDate) throws Exception {
        Query query = new Query();
        if(!Utils.checkNullOrEmpty(fromDate)){
            query.addCriteria(Criteria.where("last_login").lte(fromDate));
        }
        List<User> lstUser = mongoTemplate.find(query, User.class);
        return lstUser;
    }
//
}
