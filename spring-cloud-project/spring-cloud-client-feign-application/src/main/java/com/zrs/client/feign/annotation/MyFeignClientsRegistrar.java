package com.zrs.client.feign.annotation;

import com.zrs.client.feign.service.MySayingService;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyFeignClientsRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        System.out.println("使用");
        SingletonBeanRegistry singletonBeanRegistry = (SingletonBeanRegistry) beanDefinitionRegistry;
        singletonBeanRegistry.registerSingleton("mySayingService", new MySayingService() {
            @Override
            public String say(String name) {
                return "我是假代理";
            }
        });
    }
}
