package com.demo.service;

public class HelloService {

    private String msg;

    public String sayHello() {
        return "自定义starter输出：" + msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}