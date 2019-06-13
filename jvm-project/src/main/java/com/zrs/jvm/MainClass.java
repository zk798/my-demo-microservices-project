package com.zrs.jvm;


public class MainClass {

    public static void main(String[] args) {
        new MainClass().test();
    }

    private void test(){

        while(true){
            printMemory();
            new Thread(()->{
                while(true){

                }
            }).start();
        }
    }

    private void printMemory(){
        Runtime runtime = Runtime.getRuntime();
        System.out.print("totalMemory:"+runtime.totalMemory());
        System.out.print("maxMemory:"+runtime.maxMemory());
        System.out.print("freeMemory:"+runtime.freeMemory());
        System.out.println();


    }
}
