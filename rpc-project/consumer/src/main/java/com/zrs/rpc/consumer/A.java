package com.zrs.rpc.consumer;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.util.stream.Stream;

public interface A {
    public String  say(@RequestParam String a);

    public static void main(String[] args) throws NoSuchMethodException {
        Method say = A.class.getMethod("say",String.class);
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        String[] parameterNames =parameterNameDiscoverer.getParameterNames(say);
        Stream.of(parameterNames).forEach(System.out::println);
    }
}
