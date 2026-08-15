package com.demotest;

import com.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = {"com.demotest", "com.demo"})
@SpringBootApplication
@RestController
public class TestApplication {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHello();
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}