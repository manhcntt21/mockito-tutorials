khi chúng ta không muốn ràng buộc rõ ràng chính xác tham số truyền vào phương thức là gì, mà chỉ muốn match với tất cả instance của một class, lúc đó chúng ta có thể nghỉ tới `any()`
***
Bắt đầu bằng một service:
```java
public class UserService {
    boolean addUser(String username) {
        // Usually interacts with a database to add a user
        return true;
    }
}
```

Giờ chúng ta có thể xác nhận phương thức `addUser` với tham số `username` có nhận đối sổ kiểu String hay không bằng phương thức any() như sau:
```java
class AnyMethodApplicationTests {

    @Test
    void addUserTest() {
        UserService mockService = mock(UserService.class);

        when(mockService.addUser("kitty")).thenReturn(true);
        
        mockService.addUser("kitty");

        verify(mockService).addUser(any(String.class));
    }

}
```