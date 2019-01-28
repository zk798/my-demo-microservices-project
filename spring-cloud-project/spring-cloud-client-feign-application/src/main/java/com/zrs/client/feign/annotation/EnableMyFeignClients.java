package com.zrs.client.feign.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MyFeignClientsRegistrar.class)
public @interface EnableMyFeignClients {

    /**
     * List of classes annotated with @FeignClient. If not empty, disables classpath scanning.
     * @return
     */
    Class<?>[] clients() default {};
}
