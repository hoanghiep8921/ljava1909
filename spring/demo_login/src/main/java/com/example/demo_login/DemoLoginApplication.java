package com.example.demo_login;

import com.example.demo_login.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DemoLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoLoginApplication.class, args);
    }

}
