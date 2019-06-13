package com.zrs.firstDemo.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class ListenerBootstrapApplicatinon implements CommandLineRunner,ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplicationBuilder(ListenerBootstrapApplicatinon.class)
                .listeners(event -> System.out.println("||||||||||||||"
                        + event.getSource() + "/n" + event.getClass().getName()))
                .run();

        ConfigurableEnvironment environment = run.getEnvironment();
        System.out.println(environment);

//        ApplicationStartingEvent applicationStartingEvent = new ApplicationStartingEvent(run,args);
//                ApplicationEnvironmentPreparedEvent

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(args);
    }
}
