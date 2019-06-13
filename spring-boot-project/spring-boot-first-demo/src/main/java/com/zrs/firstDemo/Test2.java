package com.zrs.firstDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 extends Test{

    @Autowired
    private Test test;


    public static String get( Test3 test3){
        test3.get();
        return "4";
    }

    public static void main(String[] args) {
        Test2.get(()->{
            System.out.println(123);
            return "5";
        });


    }
}
