Phần này sẽ mở rộng hơn của [any()](../8-any-method), khi chúng ta không quá quân tâm về input parameter
***
BookService.java
```java
class BookService {
    public boolean isValidBook(String title, int yearPublished) {
        return title != null && !title.trim().isEmpty() && yearPublished > 0;
    }
}
/*
        ...
        ...
        ...
 */
@Test
void testArgumentMatcher() {
    // Mocking the BookService
    BookService mockService = mock(BookService.class);
    // Use ArgumentMatchers to set expectations
    when(mockService.isValidBook(anyString(), anyInt())).thenReturn(true);
    // Test with various inputs
    assert mockService.isValidBook("Mockito Guide", 2020);
    assert mockService.isValidBook("Some Title", -50);
    // Verify the interactions
    verify(mockService, times(2)).isValidBook(anyString(), anyInt());
}
```

