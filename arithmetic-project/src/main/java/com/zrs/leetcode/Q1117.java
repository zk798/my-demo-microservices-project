package com.zrs.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Q1117 {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.gc();
        long startMem = r.freeMemory();
        long startTime = System.currentTimeMillis();
        client("OOOOHOOOOOHOHHOHHOHHOOHHOOHHOOOOHHHHHHHHOHHHHOOHHOHOOOHOHHOHOOOOHOOOOOHOOOOOHHHHOHHOOHOHOOHOHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
        System.out.println("内存：" + (startMem - r.freeMemory()));
    }

    public static void client(String str) {
        H2O h2O = new H2O();

        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            if(aChar =='H'){
                new Thread(() -> {
                    try {
                        h2O.hydrogen(() -> {
                            System.out.print("H");
                        });
                    } catch (InterruptedException  e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            if(aChar =='O'){
                new Thread(() -> {
                    try {
                        h2O.oxygen(() -> {
                            System.out.print("O");
                        });
                    } catch (InterruptedException  e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }



    }
}


class H2O {

    BlockingQueue<Integer> oQueue = new ArrayBlockingQueue<>(1);
    BlockingQueue<Integer> oQueueEnd = new ArrayBlockingQueue<>(2);
    BlockingQueue<Integer> hQueue = new ArrayBlockingQueue<>(2);
    BlockingQueue<Integer> hQueueEnd = new ArrayBlockingQueue<>(3);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hQueue.put(1);
        releaseHydrogen.run();
        hQueueEnd.put(1);
        clearAllQueue();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oQueue.put(2);
        releaseOxygen.run();
        oQueueEnd.put(2);
        clearAllQueue();
    }

    public  void clearAllQueue(){

        if(hQueue.size()== 2 && oQueue.size() == 1 && hQueueEnd.size()== 2 && oQueueEnd.size() == 1){
            hQueueEnd.clear();
            oQueueEnd.clear();
            hQueue.clear();
            oQueue.clear();
        }
    }
}