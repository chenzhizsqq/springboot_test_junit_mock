package com.example.springboot_test_junit_mock.demo;

public class WelcomeService {
private GreetingService greetingService;
    public WelcomeService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    public String welcome(String name) {
        return greetingService.greet(name) + ", welcome!";
    }
}