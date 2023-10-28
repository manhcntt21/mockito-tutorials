Mockito cung cấp `spy()` method cho phép chúng ta wrap một real object và theo dõi sự tương tác của nó, trong khi vẫn gọi real method nếu được khai báo rõ ràng.

***
Ví dụ:
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
}
```
***
Thứ tự gồm 4 bước sau:
1. tạo một spy of Calculator bằng spy method
2. định nghĩa hàng vi của đối tượng
3. thực thi method
4. so sánh kết quả với assert expression
```java
class SpyMethodApplicationTests {
    @Test
    public void multiplyTestWithSpy() {
        // 1
        Calculator calculatorSpy = spy(new Calculator());
        // 2
        when(calculatorSpy.multiply(5, 2)).thenReturn(15);
        // 3
        int additionResult = calculatorSpy.add(5, 2);
        int multiplicationResult = calculatorSpy.multiply(5,2);
        // 4
        assertEquals(7, adđitionResult);
        assertEquals(15, multiplicationResult);
    }
}
```
Giải thích:
- Thay vì tại step 3, nó trả về kết quả là 10 như của real objet nhưng vì chúng ta đã định nghĩa hành vị của nó là trả về 15 nên tại 4 kết quả sẽ pass
- Nếu tại 2 chúng ta comment lại thì nó không pass nữa vì lúc này nó dùng kết quả của real object vì hành vi của spy không được định nghĩa.
***
Về cách sử dụng thì nó không khác nhiều với `mock()`, spy Object có tác dụng như là cầu nối giữa real objet và mock object. Giúp cho việc test một phần của đối tượng, trong khi vẫn giữ các phần khác. 

Nói cách khác, chúng ta vừa có thể gọi phương thức thật của object, vừa kết hợp giả lập kết quả của phương thức khác. Giúp cho việc test một chức năng trong toàn bộ chức năng được dễ dàng, linh hoạt hơn
***
sự khác nhau giữa`spy()` vs `mock()`
<table>
<tr>
<td>mock()</td><td>spy()</td>
</tr>
<tr>
<td>
Thường được sử dụng cho việc tạo fully mock, chủ yếu được sử dụng trong các bộ test lớn
</td>
<td>
Được sử dụng cho việc tạo partial or half mock object, cũng có thể được sử dụng trong các bộ test lớn
</td>
</tr>

<tr>
<td>
hành vị mặc định của mock() là không làm gì cả
<td>
hành vi mặc đinh là của real object nếu không định nghĩa hành vi của giả định
</tr>
</table>

