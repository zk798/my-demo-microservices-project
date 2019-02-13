package com.zrs.classload;

public class Demo {

    static {
        System.out.println("我是 classload-Main 的demo，classLoad是:"+Demo.class.getClassLoader());
    }
}
