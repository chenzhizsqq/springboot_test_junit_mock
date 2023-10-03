package com.example.springboot_test_junit_mock.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceCaptorTest {
@Mock
    GreetingService greetingService;
    
    @Captor
    ArgumentCaptor<String> captor;
    @Test
    public void testGreet() {
        greetingService.greet("Mockito");

        //用captor的时候，一定要用verify验证函数，这样才会在这里注意上
        verify(greetingService).greet(captor.capture());
        
        //获取captor被调用时候的值
        String name = captor.getValue();

        //确认是否为"Mockito"
        assertEquals("Mockito", name);
    }
}