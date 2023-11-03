Bên cạnh việc đảm bảo phương thúc được gọi một số lần như `times()`, mockito còn cung cấp thêm một phương thức để đảm bảo phương thức không bao giờ được gọi, nó được dùng với [verify()](../5-verify)
***
Bắt đầu bằng một service sau:
```java
public class DatabaseService {
    public String fetch(String query) throws Exception {
        return "Data";
    }

    public void processFetch() {
        
    }
}
```
Chúng ta sẽ chỉ gọi `fetch()` và dùng [verify()](../5-verify) và never() để xác nhận xem có phải `processFetch()` chưa được gọi hay không như sau:

Dùng [mock()](../1-mock-method) hoặc [spy()](../2-spy-method) là tuỳ bạn vì trong trường hợp này không có nhiều sự khác biệt.
```java
class NeverMethodApplicationTests {

    @Test
    void fetchTest() {
        DatabaseService mockService = mock(DatabaseService.class);

        mockService.fetch();

        verify(mockService, never()).processFetch();
    }

}
```
Kết quả sẽ successful khi chạy test vì processFetch() chưa được gọi.