package com.demo.autoconfigure;

import com.demo.properties.HelloProperties;
import com.demo.service.HelloService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 自定义自动配置类
 */
@AutoConfiguration
// classpath存在HelloService才生效
@ConditionalOnClass(HelloService.class)
// 开启属性绑定，把HelloProperties注入容器
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {

    private final HelloProperties helloProperties;

    // 注入配置属性
    public HelloAutoConfiguration(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    /**
     * @ConditionalOnMissingBean：容器中没有HelloService这个Bean，才创建
     * 用户自己@Bean HelloService，则此方法不会执行，实现用户覆盖自动装配
     */
    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg(helloProperties.getMsg());
        return helloService;
    }
}