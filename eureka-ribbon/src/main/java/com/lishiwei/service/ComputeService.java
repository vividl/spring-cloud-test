package com.lishiwei.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lishiwei on 17-3-31.
 */
@Service
public class ComputeService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallBack")
    public String addService() {
        return restTemplate.getForEntity("http://discovery-s/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallBack() {
        return "error";
    }
}
