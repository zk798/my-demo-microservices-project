package com.zrs.firstDemo.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHelloWorld
public class EnableHelloworldBootstrap {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableHelloworldBootstrap.class);

        context.refresh();
        Object hello = context.getBean("hello");
        System.out.println(hello);
    }
}
