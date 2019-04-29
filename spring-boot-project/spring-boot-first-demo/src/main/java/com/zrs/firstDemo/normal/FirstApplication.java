package com.zrs.firstDemo.normal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = Test.class)
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
