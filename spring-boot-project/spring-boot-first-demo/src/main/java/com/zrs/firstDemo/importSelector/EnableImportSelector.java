package com.zrs.firstDemo.importSelector;


import com.zrs.firstDemo.enable.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ImportSelectorImpl.class)
public @interface EnableImportSelector {
}
