package com.yusuf.serviceone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("test", "test");
        return ResponseEntity.ok(hashMap);
    }
}
