package com.example.demoapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JavaMailSender javaMailSender;

//    @Scheduled(fixedRate = 1000)
//    public void scheduleFixedRate(){
//        System.out.println("Đặt job chạy theo fixed second : "
//                + System.currentTimeMillis());
//    }
//
//
//    @Scheduled(fixedDelay = 2000, initialDelay = 10000)
//    public void scheduleDelayRate(){
//        System.out.println("Đặt job chạy theo delay second : "+
//                System.currentTimeMillis());
//    }

    @Scheduled(cron = "0 20 20 * * *")
    public void scheduleDay(){
        System.out.println("Đặt job chạy theo ngày");
    }

    //@Scheduled(fixedDelay = 1000000)
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("hiepdh@vnpay.vn");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);

    }
}
