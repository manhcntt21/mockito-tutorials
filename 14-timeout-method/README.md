Bên cạnh việc thực thi cái gì, còn một vấn đề nữa là nó được thực thi trong vong bao lâu, Mockito cung cấp `timeout()` để kiểm tra điều này, được kết với với [verify()](../5-verify)
***
Ví dụ:
```java
class TimeoutMethodApplicationTests {

    @Test
    void testTimeout() throws InterruptedException {
        // Create a mock of AsyncService
        AsyncService mockService = mock(AsyncService.class);
        // Invoke the method
        mockService.asyncMethod();
        // Verify that the method was called within 100 milliseconds
        verify(mockService, timeout(100)).asyncMethod();
    }

}
```