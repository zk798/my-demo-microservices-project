package com.zrs.dubbo.server.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class Provider {

    @GetMapping("/")
    public String getTest(){
        return "test";
    }

}
