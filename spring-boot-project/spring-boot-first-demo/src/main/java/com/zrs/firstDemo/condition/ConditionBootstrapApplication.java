package com.zrs.firstDemo.condition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;


@SpringBootApplication(scanBasePackageClasses = ConditionBootstrapApplication.class )
public class ConditionBootstrapApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplicationBuilder(ConditionBootstrapApplication.class).build();
        springApplication.setAdditionalProfiles("dev");
        ConfigurableApplicationContext context = springApplication.run(args);

        Service service = (Service) context.getBean("service");
        service.get();
    }

    @Bean("service")
    @Conditional(DevCondition.class)
    public Service getService(){
        return ()->System.out.println("dev");
    }

    @Bean("service")
    @Conditional(TestCondition.class)
    public Service getService2(){
        return ()->System.out.println("test");
    }

}
