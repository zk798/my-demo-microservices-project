package com.zrs.concurrent;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;


public class WrTest {
    private Product product = new Product("iPhone");

    public void strongRef() {
        Map<Product, Integer> map = new HashMap<>();
        map.put(product, 111);

        product = null;// 关键
        map.keySet().forEach(System.out::println);// 对象仍然存在！
    }
}