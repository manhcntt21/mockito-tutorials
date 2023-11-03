Bên cạnh [thenThrow()](../4-thenThrow) mockito còn cấp câp thêm doThrow(), trong hầu hết các trường hợp chúng có hoạt động giống nhau, cũng giống như [thenReturn()](../3-when-method) ở when() với [doReturn()](../11-doReturn)
***
1. Khác biệt về syntax
2. Có thể áp dụng cách này: với phương thức void thì dùng với doThrow, phương thức khác void thì dùng với when/thenThrow
***
Ví dụ;
```java
public class Notifier {
    void notify(String message) {
        System.out.println("Notification sent: " + message);
    }
}
/*
        ...
        ...
        ...
 */
class DoThrowMethodApplicationTests {

    @Test
    void testDoThrow() {
        Notifier mockNotifier = mock(Notifier.class);

        doThrow(new RuntimeException("Notification error")).when(mockNotifier).notify("Test Message");

        assertThrows(RuntimeException.class, ()-> mockNotifier.notify("Test Message"));
    }

}
        
```