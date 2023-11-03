package com.example.dothrowmethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@SpringBootTest
class DoThrowMethodApplicationTests {

    @Test
    void testDoThrow() {
        Notifier mockNotifier = mock(Notifier.class);

        doThrow(new RuntimeException("Notification error")).when(mockNotifier).notify("Test Message");

        assertThrows(RuntimeException.class, ()-> mockNotifier.notify("Test Message"));
    }

}
