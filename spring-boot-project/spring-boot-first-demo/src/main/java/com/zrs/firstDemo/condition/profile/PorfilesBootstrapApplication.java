package com.zrs.firstDemo.condition.profile;

import com.zrs.firstDemo.condition.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication(scanBasePackageClasses = PorfilesBootstrapApplication.class )
public class PorfilesBootstrapApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplicationBuilder(PorfilesBootstrapApplication.class).build();
        springApplication.setAdditionalProfiles("dev");
        ConfigurableApplicationContext context = springApplication.run(args);

        Service service = (Service) context.getBean("service");
        service.get();
    }

    @Bean("service")
    @Profile("dev")
    public Service getService(){
        return ()->System.out.println("dev");
    }

    @Bean("service")
    @Profile("test")
    public Service getService2(){
        return ()->System.out.println("test");
    }

}
