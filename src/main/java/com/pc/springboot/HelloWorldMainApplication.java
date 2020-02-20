package com.pc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication:标注这是一个主程序，表示这是一个springboot程序
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        //spring   应用   跑起来   类名.class   传入参数args
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
