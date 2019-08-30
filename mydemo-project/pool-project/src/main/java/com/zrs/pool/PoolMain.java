package com.zrs.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class PoolMain {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            int i = 0;


            while(true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                System.out.println("in="+interrupted);
                try {
                    SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i++);
            }
        });

        thread.start();
        thread.interrupt();

    }
}
