package com.zrs.firstDemo.normal;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2 implements ApplicationContextAware {

    @Autowired
    private Test test;

    ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        Test bean = applicationContext.getBean(Test.class);


    }

    @RequestMapping("/")
    public String a(){
        String s= test.get();
        return s;
    }
}
