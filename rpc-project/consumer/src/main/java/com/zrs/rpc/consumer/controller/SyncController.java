package com.zrs.rpc.consumer.controller;


import com.zrs.rpc.consumer.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class SyncController {

    @Autowired
    SyncService syncService;

    /**
     * @Async
     * @return
     */
    @GetMapping("/async/{type}")
    public String async(@PathVariable Integer type) throws ExecutionException, InterruptedException {
       if(type ==1){
           return syncService.async();
       }
       if(type == 2){
           Future<String> stringFuture = syncService.async1();
           return  stringFuture.get();
       }
       return "参数错误";
    }








}
