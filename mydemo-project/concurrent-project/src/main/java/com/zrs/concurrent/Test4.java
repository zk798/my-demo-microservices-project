package com.zrs.concurrent;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test4 {



    public static void main(String[] args) throws InterruptedException {


        Product product = new Product();
        Product product2 = new Product();

        ReferenceQueue<Product> rq = new ReferenceQueue<>();
          WeakReference<Product> wr = new WeakReference<>(product, rq);// 引用队列
          WeakReference<Product> wr2 = new WeakReference<>(product2, rq);// 引用队列
          System.out.println("wr是否已被添加至引用队列：" + wr.isEnqueued());

          Map<WeakReference<Product>, Integer> map = new HashMap<>();
           map.put(wr, 111);
           map.put(wr2, 111);

           product = null;// 关键
             System.gc();// 关键

           map.keySet().forEach(e -> System.out.println(e.get()));// 不gc()的话，还能访问对象，否则null。
           System.out.println("wr是否已被添加至引用队列：" + wr.isEnqueued());


        Collections.sort(new ArrayList());

    }
}
