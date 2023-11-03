Khi dùng [when()](../3-when-method) chúng ta có thể mô phỏng kết quả trả về mong muốn của phương thức thông qua `thenReturn()`, bên cạnh đó Mockito cung cấp thêm `doReturn()` để giúp chúng ta thực hiện điều đó.

***
Ví dụ:
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```
Chúng ta sủ dụng doReturn để mô phỏng giá trị trả về của phương thức `add` như sau:
```java
class DoReturnApplicationTests {

    @Test
    void voidTest() {
        Calculator mockCalculator = mock(Calculator.class);

        doReturn(5).when(mockCalculator).add(2, 3);

        int result = mockCalculator.add(2, 3);

        assertEquals(5, result);
    }

}
```

***
Tuy nhiên có một sự khác biệt giữa doReturn và thenReturn bên cạnh sự khác biệt về syntax:
- với doReturn: no type safety, vì tham số của nó là kiểu Object, nó sẽ không kiểm tra kiểu lúc compiler time trong khi đó với thenReturn thì nó là kiểu T.

Ngoài ra nếu là phương thức void, chúng ta có thể chuyển từ `doReturn()` sang `doNothing()`
