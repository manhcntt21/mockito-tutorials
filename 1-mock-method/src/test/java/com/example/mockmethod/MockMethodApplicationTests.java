package com.example.mockmethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class MockMethodApplicationTests {
    @Test
    public void getMessageTest() {
        // create a mock of MessageService using mock() method
        MessageService mockedService = mock(MessageService.class);
        // define mock behavior
        when(mockedService.getMessage()).thenReturn("Mocked message from the service");
        // execute mocked method
        String result = mockedService.getMessage();
        // assertion result
        assertEquals("Mocked message from the service", result);
    }

    @Mock
    public MessageService messageService;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getMessageTestWithMockAnnotation() {
        when(messageService.getMessage()).thenReturn("Mocked message from the service");
        String result = messageService.getMessage();
        assertEquals("Mocked message from the service", result);
    }
}
