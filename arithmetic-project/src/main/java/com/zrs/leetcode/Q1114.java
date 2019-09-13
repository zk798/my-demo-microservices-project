package com.zrs.leetcode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Q1114 {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        new Thread(()-> {
            try {
                foo.third(() -> System.out.print(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                foo.second(() -> System.out.print(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                foo.first(() -> System.out.print(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


class Foo {

    ReentrantLock lock = new ReentrantLock();
    Condition condition0 = lock.newCondition();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public Foo() {

    }


    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        System.out.println("--1");

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        condition1.signal();
        lock.unlock();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        System.out.println("--2");
        condition1.await();
        System.out.println("--22");
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        condition2.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        System.out.println("--3");
        condition2.await();
        System.out.println("--33");
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }


}