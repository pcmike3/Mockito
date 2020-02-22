package com.pc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @SpringBootApplication:标注这是一个主程序，表示这是一个springboot程序
 */
@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        //spring   应用   跑起来   类名.class   传入参数args
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
