Mockito không chỉ hỗ trợ việc giả lập trả về kết quả mà con hỗ trợ ném ra ngoại lệ, nó được sử dụng cùng với when() 
***
Ta có DatabaseService.java
```java
public class DatabaseService {
    public String fetch(String query) throws Exception {
        return "Data";
    }
}
```
Chúng ta sẽ giả lập việc ném ra một ngoại lệ khi gọi phương thức fetch() của DatabaseService. Chọn [mock()](../1-mock-method) hoặc [spy()](../2-spy-method) ở đây là tuỳ thuộcn vào bạn, ở tình huống này thì không có  nhiều sự khác biệt, mình sẽ chọn mock()

1. Đầu tiên, cũng phải tạo mocking object.
2. Xác định hành vi và kết quả mong muốn, ở đây là ném ra một exception.
3. so sánh với assertThrows, kết quả sẽ là True như minh hoạ ở dưới.
```java
class ThenThrowApplicationTests {

    @Test
    void fetchTest() throws Exception {
        DatabaseService mockService = mock(DatabaseService.class);
        
        when(mockService.fetch("errorQuery")).thenThrow(new Exception("Database error"));
        
        assertThrows(Exception.class, () -> mockService.fetch("errorQuery"));
    }

}

```