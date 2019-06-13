package com.zrs.firstDemo.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EventBootstrapApplication {

    public static void main(String[] args) {

        SpringApplication build = new SpringApplicationBuilder(EventBootstrapApplication.class).build();
        ConfigurableApplicationContext context = build.run(args);

        //添加代码监听器
        context.addApplicationListener(new MyEventLiensener());
        context.publishEvent(new MyEvent(new Object()));
    }


    /**添加注解监听器  */
    @EventListener(MyEvent.class)
    public void onMyEventPublished(MyEvent event){
        System.out.println("注解间听到了你");
    }
}
