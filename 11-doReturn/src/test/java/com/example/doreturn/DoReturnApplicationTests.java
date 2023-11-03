package com.example.doreturn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class DoReturnApplicationTests {

    @Test
    void voidTest() {
        Calculator mockCalculator = mock(Calculator.class);

        doReturn(5).when(mockCalculator).add(2, 3);

        int result = mockCalculator.add(2, 3);

        assertEquals(5, result);
    }

}
