package com.zrs.firstDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 {

    @Autowired
    private Test test;

    public String get2(){
        return "23";
    }

}
