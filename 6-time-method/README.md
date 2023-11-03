Đôi khi, kịch bản chúng ta yêu cầu phương thức cần phải thực hiện một số lần, để tái hiện điều đó mockito cung cấp phương thức `time()`, phương thức này có thể dùng kết hợp với [verify()](../5-verify) để kiểm tra xem có đúng nó đã được gọi số lần mình mong muốn không.
***
Khởi tạo LoggerService:
```java
public class LoggerService {
    public void logMessage(String message) {
        // log a message somewhere
    }
}
```

Chúng ta sẽ dùng verify và time để chắc chắn rằng logMessage được gọi 3 lần như sau, các bạn có thể dùng [mock()](../1-mock-method) hoặc  [spy()](../2-spy-method) đều được vì trong trường hợp này không có sự khác biệt.
```java

class TimeMethodApplicationTests {

    @Test
    void logMessageTest() {
        LoggerService mockService = mock(LoggerService.class);

        // invoke the mocked method multiple time
        mockService.logMessage("Test 1");
        mockService.logMessage("Test 1");
        mockService.logMessage("Test 1");
        mockService.logMessage("Test 2");
        mockService.logMessage("Test 3");

        verify(mockService, times(3)).logMessage("Test 1");
//        verify(mockService, times(3)).logMessage("Test 2");
    }
}
```
Như ví dụ trên:
`verify(mockService, times(3)).logMessage("Test 1");` sẽ successful trong khi đó `verify(mockService, times(3)).logMessage("Test 2");` sẽ failed.