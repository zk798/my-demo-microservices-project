package com.zrs.spi.main;



import com.zrs.spi.demo.IShout;

import java.util.ServiceLoader;

public class MainApplication {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}
