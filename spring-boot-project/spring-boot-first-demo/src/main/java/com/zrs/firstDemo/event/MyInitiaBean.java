package com.zrs.firstDemo.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyInitiaBean implements InitializingBean {


    @PostConstruct
    public void init(){
        System.out.println("init==================================init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet==================================afterPropertiesSet");
    }
}
