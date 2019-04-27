package com.zrs.concurrent;

import java.util.concurrent.*;
import java.util.logging.Logger;

public class CyclicBarrierDemo {

    Logger LOGGER = Logger.getLogger("CyclicBarrierDemo");

    public void test() throws InterruptedException {
        //构造函数1：初始化-开启屏障的方数
        CyclicBarrier barrier0 = new CyclicBarrier(2);
//通过barrier.getParties()获取开启屏障的方数
        LOGGER.info("barrier.getParties()获取开启屏障的方数：" + barrier0.getParties());
        System.out.println();
//通过barrier.getNumberWaiting()获取正在等待的线程数
        LOGGER.info("通过barrier.getNumberWaiting()获取正在等待的线程数：初始----" + barrier0.getNumberWaiting());
        System.out.println();
        new Thread(() -> {
            //添加一个等待线程
            LOGGER.info("添加第1个等待线程----" + Thread.currentThread().getName());
            try {
                barrier0.await();
                LOGGER.info(Thread.currentThread().getName() + " is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            LOGGER.info(Thread.currentThread().getName() + " is terminated.");
        }).start();
        Thread.sleep(10);
//通过barrier.getNumberWaiting()获取正在等待的线程数
        LOGGER.info("通过barrier.getNumberWaiting()获取正在等待的线程数：添加第1个等待线程---" + barrier0.getNumberWaiting());
        Thread.sleep(10);
        System.out.println();
        new Thread(() -> {
            //添加一个等待线程
            LOGGER.info("添加第2个等待线程----" + Thread.currentThread().getName());
            try {
                barrier0.await();
                LOGGER.info(Thread.currentThread().getName() + " is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            LOGGER.info(Thread.currentThread().getName() + " is terminated.");
        }).start();
        Thread.sleep(100);
        System.out.println();
//通过barrier.getNumberWaiting()获取正在等待的线程数
        LOGGER.info("通过barrier.getNumberWaiting()获取正在等待的线程数：打开屏障之后---" + barrier0.getNumberWaiting());

//已经打开的屏障，再次有线程等待的话，还会重新生效--视为循环
        new Thread(() -> {
            LOGGER.info("屏障打开之后，再有线程加入等待：" + Thread.currentThread().getName());
            try {
                //BrokenBarrierException
                barrier0.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            LOGGER.info(Thread.currentThread().getName() + " is terminated.");

        }).start();
        System.out.println();
        Thread.sleep(10);
        LOGGER.info("通过barrier.getNumberWaiting()获取正在等待的线程数：打开屏障之后---" + barrier0.getNumberWaiting());
        Thread.sleep(10);
        new Thread(() -> {
            LOGGER.info("屏障打开之后，再有线程加入等待：" + Thread.currentThread().getName());
            try {
                //BrokenBarrierException
                barrier0.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            LOGGER.info(Thread.currentThread().getName() + " is terminated.");

        }).start();
        Thread.sleep(10);
        LOGGER.info("通过barrier.getNumberWaiting()获取正在等待的线程数：打开屏障之后---" + barrier0.getNumberWaiting());
    }




    public void test2() throws InterruptedException {
        CyclicBarrier barrier2 = new CyclicBarrier(2);
//如果是一个初始的CyclicBarrier，则reset()之后，什么也不会发生
        LOGGER.info("如果是一个初始的CyclicBarrier，则reset()之后，什么也不会发生");
        barrier2.reset();
        System.out.println();
        LOGGER.info("patries="+barrier2.getParties());
        Thread.sleep(100);
//如果是一个已经打开一次的CyclicBarrier，则reset()之后，什么也不会发生
        ExecutorService executorService2 = Executors.newCachedThreadPool();
//等待两次
        for (int i = 0; i < 2; i++) {
            executorService2.submit(() -> {
                try {
                    barrier2.await();
                    LOGGER.info("222屏障已经打开."+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    LOGGER.info("222被中断");
                } catch (BrokenBarrierException e) {
                    //e.printStackTrace();
                    LOGGER.info("222被重置");
                }
            });
        }
        barrier2.reset();
        LOGGER.info("patries="+barrier2.getParties());
        Thread.sleep(100);
        System.out.println();
//如果是一个 有线程正在等待的线程，则reset()方法会使正在等待的线程抛出异常

            Future<?> submit = executorService2.submit(() -> {
                try {
                    barrier2.await();
                    LOGGER.info("333屏障已经打开.");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    LOGGER.info("333被中断");
                } catch (BrokenBarrierException e) {
                    LOGGER.info("在等待过程中，执行reset()方法，等待的线程抛出BrokenBarrierException异常，并不再等待");
                    //e.printStackTrace();
                }
            });

        Thread.sleep(100);
        barrier2.reset();
        LOGGER.info("====patries="+barrier2.getParties());
        executorService2.shutdown();

    }



    public void test3() throws InterruptedException {
        CyclicBarrier barrier1 = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
//添加一个用await()等待的线程
        executorService.submit(() -> {
            try {
                //等待，除非：1.屏障打开;2.本线程被interrupt;3.其他等待线程被interrupted;4.其他等待线程timeout;5.其他线程调用reset()
                barrier1.await();
            } catch (InterruptedException e) {
                LOGGER.info(Thread.currentThread().getName() + " is interrupted.");
                //e.printStackTrace();
            } catch (BrokenBarrierException e) {
                LOGGER.info(Thread.currentThread().getName() + " is been broken.");
                //e.printStackTrace();
            }
        });
        Thread.sleep(10);
        LOGGER.info("刚开始，屏障是否破损：" + barrier1.isBroken());
//添加一个等待线程-并超时
        executorService.submit(() -> {
            try {
                //等待1s，除非：1.屏障打开(返回true);2.本线程被interrupt;3.本线程timeout;4.其他等待线程被interrupted;5.其他等待线程timeout;6.其他线程调用reset()
                barrier1.await(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.info(Thread.currentThread().getName() + " is interrupted.");
                //e.printStackTrace();
            } catch (BrokenBarrierException e) {
                LOGGER.info(Thread.currentThread().getName() + " is been reset().");
                //e.printStackTrace();
            } catch (TimeoutException e) {
                LOGGER.info(Thread.currentThread().getName() + " is timeout.");
                //e.printStackTrace();
            }
        });
        Thread.sleep(100);
        LOGGER.info("当前等待线程数量：" + barrier1.getNumberWaiting());
        Thread.sleep(1000);
        LOGGER.info("当前等待线程数量：" + barrier1.getNumberWaiting());
        LOGGER.info("当等待的线程timeout时，当前屏障是否破损：" + barrier1.isBroken());
        LOGGER.info("等待的线程中，如果有一个出现问题，则此线程会抛出相应的异常；其他线程都会抛出BrokenBarrierException异常。");

        System.out.println();
        Thread.sleep(5000);
//通过reset()重置屏障回初始状态，也包括是否破损
        barrier1.reset();
        LOGGER.info("reset()之后，当前屏障是否破损：" + barrier1.isBroken());
        LOGGER.info("reset()之后，当前等待线程数量：" + barrier1.getNumberWaiting());
        executorService.shutdown();
    }


    public static void main(String[] args) {
        try {
            new CyclicBarrierDemo().test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
