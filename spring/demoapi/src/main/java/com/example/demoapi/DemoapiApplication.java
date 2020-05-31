package com.example.demoapi;

import com.example.demoapi.model.User;
import com.example.demoapi.repository.UserRepository;
import com.example.demoapi.services.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoapiApplication.class, args);
    }

    @Autowired
    TokenAuthenticationService tokenAuthenticationService;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        String token = tokenAuthenticationService.
                generateJWT("userId");
        System.out.println(token);
        String userName = tokenAuthenticationService.
                readJWT(token);
        System.out.println(userName);
//        User u = new User();
//        u.setUsername("hiepdh");
//        u.setPassword("123456");
//        userRepository.save(u);
    }
}
