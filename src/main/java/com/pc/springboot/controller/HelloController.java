package com.pc.springboot.controller;

import com.pc.someTest.Employee;
import com.pc.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody
@Controller*/
@RestController//等于上面两个注解
public class HelloController {

    @Value("${es.name:mike}")
    private String name;

    @Autowired
    private Employee e;

    @Bean("getE")
    public Employee getE(){
        Employee e = new Employee();
        e.setAge(1);
        e.setDept("2");
        e.setName("name");
        return e;
    }
    @Autowired
    HelloService helloService;
    //@ResponseBody//可以直接加在类前面，表示这个类下所有的方法返回数据都直接传给浏览器（如果是对象自动转为JSON数据）
    @RequestMapping("/hello")
    public void hello(){
        System.out.println(name);
        System.out.println(e.getAge());
        helloService.helloService();

    }
}
