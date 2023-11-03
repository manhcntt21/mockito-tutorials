package com.example.verify;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class VerifyApplicationTests {

    @Test
    void sendNotificationTest() {
        NotificationService mockService = mock(NotificationService.class);

        mockService.sendNotification("Hello", "Vietnam");

        verify(mockService).sendNotification("Hello", "Vietnam");
    }

}
