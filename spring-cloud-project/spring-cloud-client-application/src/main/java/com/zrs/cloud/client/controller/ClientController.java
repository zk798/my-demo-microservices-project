package com.zrs.cloud.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    private volatile Map<String, Set<String>> targetUrlsCache = new HashMap<>();

    @Scheduled(fixedDelay = 10000)
    public void updateServerNames(){
        Map<String, Set<String>> oldTargetUrlsCache = targetUrlsCache;
        Map<String, Set<String>>  newTargetUrlsCache = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(s);

            Set<String> set = instances.stream().map(instance ->
                 instance.getUri().toString()
            ).collect(Collectors.toSet());
            log.info("服务名称：{}，列表：{}",s, set);
            newTargetUrlsCache.put(s,set);
        });
        targetUrlsCache = newTargetUrlsCache;
        oldTargetUrlsCache.clear();

    }



    @GetMapping("/{applicationName}/invoke/say")
    public String say(@PathVariable String applicationName, @RequestParam String name){

        String url = loadBalancedGetUrl(applicationName);

        String forObject = restTemplate.getForObject(url+"/say?name="+name, String.class);
        return forObject;
    }

    private String loadBalancedGetUrl(String applicationName){
        Set<String> urls = targetUrlsCache.get(applicationName);
        List<String> urlList = new ArrayList<>(urls);
        int i = RandomUtils.nextInt(urlList.size());
        String currUrl = urlList.get(i);
        return currUrl;
    }



    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }
}
