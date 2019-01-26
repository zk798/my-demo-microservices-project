package com.zrs.cloud.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ServerController {

    @GetMapping("/say")
    public String say(@RequestParam String name){
        log.info("调用say接口，name={}",name);
        return "say:"+name;
    }
}
