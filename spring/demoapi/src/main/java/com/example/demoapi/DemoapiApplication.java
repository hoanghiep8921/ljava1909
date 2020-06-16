package com.example.demoapi;

import com.example.demoapi.model.ProductModal;
import com.example.demoapi.model.User;
import com.example.demoapi.repository.ProductRepository;
import com.example.demoapi.repository.UserRepository;
import com.example.demoapi.services.JobService;
import com.example.demoapi.services.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class DemoapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoapiApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    JobService jobService;

    @Override
    public void run(String... args) throws Exception {
        jobService.sendEmail();
        //tạo user
//        User user = new User();
//        user.setId("");
//        user.setPassword("123456");
//        user.setUsername("admin");
//        user.setCart(new ArrayList<>());
//        userRepository.save(user);
//
//        //tạo sản phẩm
//        for(int i = 0;i < 10;i++){
//            ProductModal productModal  = new ProductModal();
//            productModal.setId("CODE"+i);
//            productModal.setImage("https://content.fortune.com/wp-content/uploads/2018/04/iphone8_iphone8plus_product_red_front_back_041018-e1523280198726.jpg");
//            productModal.setName("Product Name "+i);
//            productModal.setNumber("1000");
//            productModal.setPrice("2000000");
//            productRepository.save(productModal);
//        }

    }
}
