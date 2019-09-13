package com.zrs.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Q1115 {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);

        new Thread(()->{
            fooBar.bar();
        }).start();
        new Thread(()->{
            fooBar.foo();
        }).start();

    }

}

class FooBar {
    CyclicBarrier cb = new CyclicBarrier(2);
    static volatile int s = 0;
    int n;
    public FooBar(int n) {
        this.n=n;
    }

    public void foo() {
        for (int i = 0; i < n; i++) {

            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            while(s%2!=0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("foo");

            s++;

        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {

            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            while(s%2==0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("bar");
            s++;
        }
    }
}
