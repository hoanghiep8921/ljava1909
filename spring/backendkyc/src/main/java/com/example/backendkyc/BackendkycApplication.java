package com.example.backendkyc;

import com.example.backendkyc.model.*;
import com.example.backendkyc.reposiroty.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableScheduling
public class BackendkycApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendkycApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Function function = new Function();
//        function.setDescription("Quyền chỉnh sửa tất cả");
//        function.setFunctionCode("SYS_ABC");
//        function.setStatus(1);
//
//        Function function2 = new Function();
//        function2.setDescription("Quyền đọc tất cả");
//        function2.setFunctionCode("SYS_DEF");
//        function2.setStatus(1);
//
//        Role role = new Role();
//        role.setDescription("User is the best");
//        role.setRoleCode("USER");
//        role.setStatus(1);
//        role.setFunctions(Arrays.asList(function,function2).stream().collect(Collectors.toSet()));
//        session.save(role);
    }
}
