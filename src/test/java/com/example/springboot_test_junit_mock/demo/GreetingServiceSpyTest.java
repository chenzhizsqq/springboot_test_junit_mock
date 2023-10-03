package com.example.springboot_test_junit_mock.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceSpyTest {
@Spy
    GreetingService greetingService;
    @Test
    public void testGreet() {
        //当用上greet函数时候，就返回"Hello, Mockito"
        when(greetingService.greet(anyString())).thenReturn("Hello, Mockito");

        //确认greet函数的值
        assertEquals("Hello, Mockito", greetingService.greet("John Doe"));
        assertEquals("Hello, Jane Doe", greetingService.greet("Jane Doe"));
    }
}