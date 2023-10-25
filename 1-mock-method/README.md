Một trong những method cơ bản của Mockito là `mock()`, bên cạnh việc sử dụng `@Mock` trở nên phổ biến và hiệu quả thì việc sử dụng `mock()` method thường đưa ta sự linh hoạt trong một số kịch bản cụ thể
***
Dependency:
- Trong `spring-boot-starter-test` đã chứa `mockito-core` và `junit-jupiter-engine` nên chúng ta không cần phải import thêm gì nữa
```properties
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
***
1. Bắt đầu bằng một service class:
```java
public class MessageService {
    public String getMessage() {
        return "Real message from the service";
    }
}
```
2. Xây dựng test gồm 4 bước như dưới đây
   1. tạo một mocking của một service
   2. định nghĩa hành vi của nó
   3. thực hiện hành vi
   4. so sánh với biểu thức assert
```java
class MockMethodApplicationTests {
    @Test
    public void getMessageTest() {
        // create a mocking of MessageService using mock() method
        MessageService mockedService = mock(MessageService.class);
        // define mock behavior
        when(mockedService.getMessage()).thenReturn("Mocked message from the service");
        // execute mocked method
        String result = mockedService.getMessage();
        System.out.println(result);
        // assertion result
        assertEquals("Mocked message from the service", result);
    }
}
```
***
Ở đấy chúng ta muốn vẫn có thể dùng @Mock như sau
```java
    @Mock
    public MessageService messageService;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getMessageTestWithMockAnnotation() {
        when(messageService.getMessage()).thenReturn("Mocked message from the service");
        String result = messageService.getMessage();
        assertEquals("Mocked message from the service", result);
    }
```
Phải khởi tạo mocked object bằng MockitoAnnotations.openMocks(this) để tránh lỗi `NullPointerException`

