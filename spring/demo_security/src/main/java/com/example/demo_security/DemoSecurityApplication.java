package com.example.demo_security;

import com.example.demo_security.model.User;
import com.example.demo_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setId("hiepdh");
//        user.setName("Hiẹp");
//        user.setPassword("$2y$12$.1DwtUliYh8JhWGqt75Sm.DrAa7zcvhfCanlxGJgJVeLB6jRxyztq");
//        user.setRoles(Arrays.asList("ADMIN","USER"));
//        userRepository.save(user);
    }
}
