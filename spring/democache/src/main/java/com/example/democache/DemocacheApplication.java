package com.example.democache;

import com.example.democache.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemocacheApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DemocacheApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemocacheApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
    }
}
