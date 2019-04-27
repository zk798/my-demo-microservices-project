package com.zrs.firstDemo;

import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.EventObject;

@Component
public class Test  {

    public String get(){
        return "23";
    }

}
