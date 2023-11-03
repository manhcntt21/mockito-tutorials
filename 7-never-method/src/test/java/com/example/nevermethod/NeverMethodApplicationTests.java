package com.example.nevermethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class NeverMethodApplicationTests {

    @Test
    void fetchTest() {
        DatabaseService mockService = mock(DatabaseService.class);

        mockService.fetch();

        verify(mockService, never()).processFetch();
    }

}
