package com.zrs.firstDemo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TestCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        System.out.println("activeProfiles"+activeProfiles);
        System.out.println("test metadata"+metadata);
        return false;
    }
}
