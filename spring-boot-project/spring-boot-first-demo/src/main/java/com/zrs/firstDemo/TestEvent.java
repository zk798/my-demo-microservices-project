package com.zrs.firstDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EventObject;


public class TestEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TestEvent(Test source) {
        super(source);
    }


}
