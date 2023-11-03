package com.example.eqmethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class EqMethodApplicationTests {

    @Test
    void isAvailableTest() {
        //1
        BookService mockService = mock(BookService.class);
        //2
        when(mockService.isAvailable("Harry Potter")).thenReturn(true);
        //3
        mockService.isAvailable("Harry Potter");
        //4
        verify(mockService).isAvailable(eq("Harry Potter"));
    }

}
