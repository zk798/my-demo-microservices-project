package com.zrs.db;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DbApplication {

    public static void main(String[] args) {
        System.out.println(1<<4);

        DbApplication dbApplication = new DbApplication();
        System.out.println("static =====");
        new Thread(()->{ dbApplication.get();}).start();

        System.out.println("static =====");
        new Thread(()->{ dbApplication.get();}).start();
    }

    public synchronized void get(){
        try {
            System.out.println("get 等待");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized static void get2(){
        try {
            System.out.println("get2 等待");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
