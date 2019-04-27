package com.zrs.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class ConcurrentApplication {


    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            System.out.println("i="+i);
            re:
            for (int j = 0; j < 4; j++) {
                System.out.println("jj="+j);
                for (int k = 0; k < 5; k++) {
                    System.out.println("kkk="+k);
                    break re;
                }

            }
        }
        System.out.println(222);




    }


}
