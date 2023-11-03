package com.example.argumentmatcher;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArgumentMatcherApplicationTests {

    @Test
    void testArgumentMatcher() {
        // Mocking the BookService
        BookService mockService = mock(BookService.class);
        // Use ArgumentMatchers to set expectations
        when(mockService.isValidBook(anyString(), anyInt())).thenReturn(true);
        // Test with various inputs
        assert mockService.isValidBook("Mockito Guide", 2020);
        assert mockService.isValidBook("Some Title", -50);
        // Verify the interactions
        verify(mockService, times(2)).isValidBook(anyString(), anyInt());
    }

}
