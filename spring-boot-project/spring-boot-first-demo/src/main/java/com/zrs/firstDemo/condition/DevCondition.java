package com.zrs.firstDemo.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Slf4j
public class DevCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        System.out.println("activeProfiles"+activeProfiles);
        System.out.println("dev metadata"+metadata);
        return true;
    }
}
