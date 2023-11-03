Trong một luồng nghiệp vụ thứ tự các step là rất quan trọng, mockito cung cấp `inOrder()` method để đảm bảo các phương thức được gọi theo một thứ tự nhất định. Khi dùng được kết hợp với [verify()](../5-verify)
***
Bắt đầu bằng AccountService
```java
public class AccountService {
    public void deposit(int amount) {
        // logic to deposit money
    }
    
    public void withdraw(int amount) {
        // logic to withdraw money
    }
}
```
Vẫn như các lần trước, các bạn có thể tuỳ chọn [mock()](../1-mock-method) hoặc [spy()](../2-spy-method) trong ví dụ này không có sự khác biệt

Ví dụ chúng ta cần phải gửi tiền vào tài khoản, sau khi tài khoản có tiền mới có thể rút 
, được tiền (với số tiền nhỏ hơn số dư), logic được đảm bảo trong mockito thông qua `inOrder()` như sau
```java
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

```
Nếu bạn đổi thứ gọi tại `2` hoặc giá trị truyền vào không đúng như `3` đều sẽ đẫn đến test bị failed.

