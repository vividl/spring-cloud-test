package com.lishiwei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lishiwei on 17-3-29.
 */
@Slf4j
@RestController
public class ComputeController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        log.info("/add , host:" + instance.getHost() + ", server_id:" + instance.getServiceId() + ", result:" + (a
                                                                                                                 + b));
        return a + b;
    }

    @RequestMapping(value = "/minus", method = RequestMethod.GET)
    public Integer minus(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        log.info("/minus , host:" + instance.getHost() + ", server_id:" + instance.getServiceId() + ", result:" + (a
                                                                                                                 - b));
        return a - b;
    }
}
