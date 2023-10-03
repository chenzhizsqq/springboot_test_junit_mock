package com.example.springboot_test_junit_mock.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WelcomeServiceTest {
    @Mock
    GreetingService greetingService;
    
    //就是DI 的 Mock，自动做一个WelcomeService的对象
    @InjectMocks
    WelcomeService welcomeService;

    @Test
    public void testWelcome() {
        //当用上greet函数时候，就返回"Hello, Mockito"
        when(greetingService.greet(anyString())).thenReturn("Hello, Mockito");

        //确认welcomeService的welcome函数，是否为"Hello, Mockito, welcome!"
        assertEquals("Hello, Mockito, welcome!", welcomeService.welcome("John Doe"));
    }
}