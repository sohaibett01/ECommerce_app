package com.codeWithProjects.ecom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Application is running!");
        response.put("status", "OK");
        response.put("endpoint", "/authenticate");
        return response;
    }

    @GetMapping("/api/public/test")
    public Map<String, String> test() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Public endpoint is accessible");
        response.put("status", "OK");
        return response;
    }
}

