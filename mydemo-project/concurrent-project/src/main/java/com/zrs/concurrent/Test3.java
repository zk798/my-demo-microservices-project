package com.zrs.concurrent;

public class Test3 {
    private static Test3 ourInstance = new Test3();

    public static Test3 getInstance() {
        return ourInstance;
    }

    private Test3() {
    }
}
