package com.pc.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Scheduled(cron = "0-30 * * * * MON-SAT")
    public void helloService(){
        System.out.println("hello");

    }
}
