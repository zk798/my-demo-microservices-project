package com.zrs.classload;

public class Demo2 {

    static {
        System.out.println("我是 classload-A 的demo2，classLoad是:"+ Demo2.class.getClassLoader());

        Demo demo =new Demo();
    }
}