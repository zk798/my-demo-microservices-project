package com.zrs.classload.main;

import com.zrs.classload.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassloadMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassloadMainApplication.class,args);



    }

    Demo demo =new Demo();

    public void init(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            Class<?> aClass = classLoader.loadClass("com.zrs.classload.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


//    Demo demo1 =new Demo();
//    Demo2 demo2 =new Demo2();
//    Demo2 demo3 =new Demo2();

//    java.lang.String s = new String();

}
