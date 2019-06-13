package com.zrs.firstDemo.event;

import org.springframework.context.ApplicationListener;

public class MyEventLiensener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("我监听到了你");
        Object source = event.getSource();

    }
}
