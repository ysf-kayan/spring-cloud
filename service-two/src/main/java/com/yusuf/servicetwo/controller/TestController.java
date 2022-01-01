package com.yusuf.servicetwo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    private final DiscoveryClient discoveryClient;

    public TestController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("test", "test");
        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("service-list")
    public ResponseEntity<Object> getServiceList() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLIENT-SERVICE");
        var serviceInfoList = instances.stream().map(instance -> {
            Map<String, Object> map = new HashMap<>();
            map.put("host", instance.getHost());
            map.put("port", instance.getPort());
            map.put("serviceId", instance.getServiceId());
            return map;
        }).collect(Collectors.toList());
        var resultMap = new HashMap<String, Object>();
        resultMap.put("services", serviceInfoList);
        return ResponseEntity.ok(resultMap);
    }

}
