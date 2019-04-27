package com.zrs.firstDemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class,args);
    }

//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context){
//        return args -> System.out.println("当前webServer是:"+context.getWebServer().getClass().getName());
//    }

//    @EventListener(WebServerInitializedEvent.class)
//    public void onWebServerReady(WebServerInitializedEvent event){
//        System.out.println("当前webServer是:"+event.getWebServer().getClass().getName());
//        Test test = new Test();
//        new TestEvent(test);
//
//    }
//
//    @EventListener(TestEvent.class)
//    public void onTestReady(TestEvent test){
//        System.out.println("当前webServer是:"+test.getClass().getName());
//    }


}
