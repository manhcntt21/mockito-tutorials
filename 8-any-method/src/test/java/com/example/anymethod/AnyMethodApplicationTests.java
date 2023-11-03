package com.example.anymethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AnyMethodApplicationTests {

    @Test
    void addUserTest() {
        UserService mockService = mock(UserService.class);

        when(mockService.addUser("kitty")).thenReturn(true);

        mockService.addUser("kitty");

        verify(mockService).addUser(any(String.class));
    }

}
