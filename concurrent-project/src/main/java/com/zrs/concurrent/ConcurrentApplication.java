package com.zrs.concurrent;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class ConcurrentApplication {

    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(-1);
        new Thread(()->{
            try {
                System.out.println("开始阻塞1");
                semaphore.acquire();
                System.out.println("结束阻塞1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println("开始阻塞2");
                semaphore.acquire();
                System.out.println("结束阻塞2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        for (int i = 0; i < 4; i++) {
            System.out.println("i="+i);

            semaphore.release();
            Set set = new LinkedHashSet<>();
        }


    }


}
