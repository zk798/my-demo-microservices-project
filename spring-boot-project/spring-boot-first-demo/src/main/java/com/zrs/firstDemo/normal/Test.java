package com.zrs.firstDemo.normal;

import org.springframework.stereotype.Component;


@Component
public class Test  {

    public String get(){
        System.out.println("get方法被调用");
        return "000000000";
    }

}
