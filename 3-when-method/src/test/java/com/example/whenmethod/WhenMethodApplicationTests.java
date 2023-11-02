package com.example.whenmethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class WhenMethodApplicationTests {

    @Test
    void forecastTest() {
        WeatherService mockService = mock(WeatherService.class);

        when(mockService.forecast("London")).thenReturn("Rainy");

        String result = mockService.forecast("London");

        assertEquals("Rainy", result);
    }

}
