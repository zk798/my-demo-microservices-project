package com.zrs.client.feign.controller;

import com.zrs.client.feign.service.MySayingService;
import com.zrs.client.feign.service.SayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayController {
    @Autowired
    SayingService sayingService;
    @Autowired
    MySayingService mySayingService;

    @GetMapping("/cont/say")
    public String sayController(@RequestParam String name){
        return sayingService.say(name);
    }
    @GetMapping("/cont/say2")
    public String sayController2(@RequestParam String name){
        return mySayingService.say(name);
    }
}
