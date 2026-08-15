package com.demotest.config;


import com.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public HelloService getHelloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg("我是用户手动创建，覆盖自动装配");
        return helloService;
    }
}
