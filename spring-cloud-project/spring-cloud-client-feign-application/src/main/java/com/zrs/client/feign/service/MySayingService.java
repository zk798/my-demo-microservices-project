package com.zrs.client.feign.service;

import com.zrs.client.feign.annotation.MyClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@MyClient("spring-cloud-service-application")
public interface MySayingService {

    @GetMapping("/say")
    public String say(@RequestParam("name") String name);
}
