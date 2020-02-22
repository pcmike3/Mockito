package com.pc.springboot.controller;

import com.pc.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody
@Controller*/
@RestController//等于上面两个注解
public class HelloController {

    @Autowired
    HelloService helloService;
    //@ResponseBody//可以直接加在类前面，表示这个类下所有的方法返回数据都直接传给浏览器（如果是对象自动转为JSON数据）
    @RequestMapping("/hello")
    public void hello(){
        helloService.helloService();

    }
}
