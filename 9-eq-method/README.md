Bên cạnh việc ràng buộc kiểu của đối số như [any()](../8-any-method), `mockito` còn hỗ trợ một phương thức khác để yêu cầu đối số là một giá trị cụ thể thông qua phương thức `eq()`, nó được được với [verify()](../5-verify) và được gọi thông qua [when()](../3-when-method)
***
Bắt đầu bằng service sau:
```java
public class BookService {
    public boolean isAvailable(String bookName) {
        // interacts with a database or inventory system
        return true;
    }
}
```

Giả sử chúng ta cần xác định xem có truyền đúng đối số "Harry Potter" phương thức isAvailable() không, thực hiện như sau:

Vẫn như các lần trước, các bạn có thể tuỳ chọn [mock()](../1-mock-method) hoặc [spy()](../2-spy-method) trong ví dụ này không có sự khác biệt
```java
class EqMethodApplicationTests {

    @Test
    void isAvailableTest() {
        //1
        BookService mockService = mock(BookService.class);
        //2 
        when(mockService.isAvailable("Harry Potter")).thenReturn(true);
        //3
        mockService.isAvailable("Harry Potter");
        //4
        verify(mockService).isAvailable(eq("Harry Potter"));
    }

}
```
Nếu tại 3 các bạn truyền giá trị khác sẽ failed, vì tại 4 chúng ta đã ràng buộc chính xác giá trị cần truyền khi gọi phương thức `available()`