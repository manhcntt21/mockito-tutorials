Phần này chúng ta sẽ tiếp tục tìm hiểu về một phương thức nữa trong `mockito` đó là `when()`, ở các phần trước chúng ta cũng có sử dụng qua rồi nhưng chưa đi sâu, phần nay sẽ giải thích rõ hơn.

Về cơ bản, nó là nơi bắt đầu trong việc xác định hành vi đối tượng và thiết lập kỳ vọng của các phương thức đó.
***
Chúng ta sẽ dùng `when()` để xác định hành vi của mocking object, ở đây chúng ta có thể dùng mock() hoặc spy() để khởi tạo đối tượng giả, tuỳ các bạn chọn, mình sẽ chọn mock() method

Ta có một service giả định sau:
```java
public class WeatherService {
    public String forecast(String city) {
        return "Sunny";
    }
}
```

Sử dụng when() như sau
```java
class WhenMethodApplicationTests {

    @Test
    void forecastTest() {
        WeatherService mockService = mock(WeatherService.class);

        when(mockService.forecast("London")).thenReturn("Rainy");

        String result = mockService.forecast("London");

        assertEquals("Rainy", result);
    }

}
```
*Chú ý*:
- Về giải thích các bước các bạn có thể xem lại [bài 1](../1-mock-method) nếu dùng mock hoặc [bài 2](../2-spy-method) nếu dùng spy
***
Nói chung when() là một phương thức quan trọng, là nơi xác định hành vi và giả lập kết quả, nhờ nó cũng dễ dàng xác định các luồng logic test một cách rõ ràng, thuận lợi trong quá trình viết unit test.