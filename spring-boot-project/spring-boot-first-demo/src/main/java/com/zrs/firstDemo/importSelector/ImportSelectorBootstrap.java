package com.zrs.firstDemo.importSelector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableImportSelector
public class ImportSelectorBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ImportSelectorBootstrap.class);
        context.refresh();
        HelloWorld bean = context.getBean(HelloWorld.class);
        bean.say();

    }
}
