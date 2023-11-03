Trong `Mockito`, `verify()` dùng để kiểm tra xem một phương thức cụ thể của một mock object với tham số được chỉ định và số lần cụ thể chạy trong một test.

Nó giúp chúng ta tương tác với đối tượng giả theo cách mình mong muốn.
***
NotificationService.java
```java
public class NotificationService {
    public void sendNotification(String message, String recipient) {
        // send a message to the right recipient
    }
}
```

Chúng ta sẽ dùng verify để chắc chắn rằng chúng ta đã truyền đúng tham số cho phương thức `sendNotification` của mock object.
```java
class VerifyApplicationTests {

    @Test
    void sendNotificationTest() {
        NotificationService mockService = mock(NotificationService.class);

        mockService.sendNotification("Hello", "Vietnam");

        verify(mockService).sendNotification("Hello", "Vietnam");
    }

}
```