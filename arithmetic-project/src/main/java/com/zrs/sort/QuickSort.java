package com.zrs.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {3,7,4,8,5,9,6,43,3,2};
        new QuickSort().sort(arr,0, arr.length-1);
//        print(arr);
        Arrays.asList(arr).forEach(a-> System.out.println(a.toString()));
    }

    public void sort(int[] arr, int low,int high){
        if(high <= low){
            return;
        }
        int m = getIndex(arr, low, high);
//        System.out.print("m="+m+",low="+low+",high="+high+"----->");
//        print(arr);
        sort(arr,low,m-1);
        sort(arr, m + 1, high);

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
        System.out.println(low+"=="+high);
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
