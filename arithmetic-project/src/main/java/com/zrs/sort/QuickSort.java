package com.zrs.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuickSort {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    boolean f = false;
    public static void main(String[] args) throws InterruptedException {



        Random random = new Random();

        int[] arr = new int[100];
        for (int j = 0; j < 100; j++) {
            arr[j] = random.nextInt(1000);
        }

//        print(arr);
//        long s = System.currentTimeMillis();
//        new QuickSort().sort(arr,0, arr.length-1);
//        print(arr);
//        System.out.println(System.currentTimeMillis() - s+"毫秒");

        TimeUnit.SECONDS.sleep(3);
        print(arr);
        long s2 = System.currentTimeMillis();
        new QuickSort().paraSort(arr,0, arr.length-1);

        print(arr);
        System.out.println(System.currentTimeMillis() - s2+"毫秒");
    }

    public void sort(int[] arr, int low,int high){
        if(high <= low){
            return;
        }
        int m = getIndex(arr, low, high);
        sort(arr,low,m-1);
        sort(arr, m + 1, high);
    }


    public void paraSort(int[] arr, int low,int high){
        if(high <= low){
            return;
        }
        int m = getIndex(arr, low, high);

            executorService.submit(() -> paraSort(arr, low, m - 1));
            executorService.submit(() -> paraSort(arr, m + 1, high));



    }

    private int getIndex(int[] arr, int low, int high) {
        int temp = arr[low];
        while(low < high){
            while(low < high && arr[high] >= temp){
                high --;
            }
            if(low < high){
                arr[low] = arr[high];
                low ++;
            }
            while(low < high && arr[low] <= temp){
                low ++;
            }
            if(low< high){
                arr[high] = arr[low];
                high --;
            }
        }
//        System.out.println(low+"=="+high);
        arr[low] = temp;
        return low;

    }

    public static void print(int[] arr){



        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(",");

        }
        System.out.println();
    }
}
