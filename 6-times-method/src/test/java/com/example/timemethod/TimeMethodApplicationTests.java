package com.example.timemethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class TimeMethodApplicationTests {

    @Test
    void logMessageTest() {
        LoggerService mockService = mock(LoggerService.class);

        // invoke the mocked method multiple time
        mockService.logMessage("Test 1");
        mockService.logMessage("Test 1");
        mockService.logMessage("Test 1");
        mockService.logMessage("Test 2");
        mockService.logMessage("Test 3");

        verify(mockService, times(3)).logMessage("Test 1");
//        verify(mockService, times(3)).logMessage("Test 2");
    }
}
