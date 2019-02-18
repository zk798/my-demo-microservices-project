package com.zrs.spi.demo;


public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}