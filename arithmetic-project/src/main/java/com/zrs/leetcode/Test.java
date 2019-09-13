package com.zrs.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(1);

        System.out.println(q.size());
        q.put(1);
        System.out.println("put 1");
        System.out.println(q.size());

        q.put(2);
        System.out.println("put 2");

        q.put(3);
        System.out.println("put 3");
    }
}
