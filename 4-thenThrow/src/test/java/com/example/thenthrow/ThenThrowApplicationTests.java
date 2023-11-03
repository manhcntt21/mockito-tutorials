package com.example.thenthrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ThenThrowApplicationTests {

    @Test
    void fetchTest() throws Exception {
        DatabaseService mockService = mock(DatabaseService.class);

        when(mockService.fetch("errorQuery")).thenThrow(new Exception("Database error"));

        assertThrows(Exception.class, () -> mockService.fetch("errorQuery"));
    }

}
