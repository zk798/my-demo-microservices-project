package com.zrs.concurrent;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class semaphore {


    static int result=0;
    public static void main(String[] args) throws InterruptedException {
        new semaphore().test(3);
    }

    public void test(int n) throws InterruptedException {
        Semaphore[] semaphores = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            Semaphore semaphore = new Semaphore(0);
            semaphores[i] = semaphore;

        }
      
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            Semaphore curr = semaphores[i];
            Semaphore next = i==n-1 ? semaphores[0]: semaphores[i+1];

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            curr.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("i=" + Thread.currentThread().getName() + "," + result++);
                        if (result > 100) {
                            System.exit(0);
                        }
                        next.release();
                    }
                }
            });
            threads[i] = thread;
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(n,n,1,TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        for (int i = 0; i < threads.length; i++) {
//            threadPoolExecutor.execute(threads[i]);
            threads[i].start();
        }
        semaphores[0].release();
    }
}
