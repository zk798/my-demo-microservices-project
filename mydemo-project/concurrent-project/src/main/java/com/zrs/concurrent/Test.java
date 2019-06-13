package com.zrs.concurrent;

import javax.annotation.Resource;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {

    @Resource

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Object take = queue.take();

        System.out.println(1);

    }
}
