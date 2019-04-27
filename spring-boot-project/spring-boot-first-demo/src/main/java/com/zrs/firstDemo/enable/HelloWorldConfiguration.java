package com.zrs.firstDemo.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean("hello")
    public String getHelloWorld(){
        return "hello world";
    }


}
