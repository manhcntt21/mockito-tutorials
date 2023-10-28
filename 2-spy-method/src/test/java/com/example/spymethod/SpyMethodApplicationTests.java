package com.example.spymethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpyMethodApplicationTests {
    @Test
    public void multiplyTestWithSpy() {
        // 1
        Calculator calculatorSpy = spy(new Calculator());
        // 2
        when(calculatorSpy.multiply(5, 2)).thenReturn(15);
        // 3
        int additionResult = calculatorSpy.add(5, 2);
        int multiplicationResult = calculatorSpy.multiply(5,2);
        // 4
        assertEquals(7, additionResult);
        assertEquals(15, multiplicationResult);
    }
}
