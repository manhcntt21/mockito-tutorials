package com.example.timeoutmethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class TimeoutMethodApplicationTests {

    @Test
    void testTimeout() throws InterruptedException {
        // Create a mock of AsyncService
        AsyncService mockService = mock(AsyncService.class);
        // Invoke the method
        mockService.asyncMethod();
        // Verify that the method was called within 100 milliseconds
        verify(mockService, timeout(100)).asyncMethod();
    }

}
