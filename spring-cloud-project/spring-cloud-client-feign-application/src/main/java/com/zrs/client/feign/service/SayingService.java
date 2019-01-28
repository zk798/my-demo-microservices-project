package com.zrs.client.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-service-application")
public interface SayingService {

    @GetMapping("/say")
    public String say(@RequestParam("name") String name);
}
