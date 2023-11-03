package com.example.inordermethod;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
class InOrderMethodApplicationTests {

    @Test
    void orderOfInvocationTest() {
        //1
        AccountService mockService = mock(AccountService.class);

        //2
        mockService.deposit(10);
        mockService.withdraw(50);

        //3
        // use inOrder
        InOrder inOrder = Mockito.inOrder(mockService);
        inOrder.verify(mockService).deposit(100);
        inOrder.verify(mockService).withdraw(50);
    }

}
