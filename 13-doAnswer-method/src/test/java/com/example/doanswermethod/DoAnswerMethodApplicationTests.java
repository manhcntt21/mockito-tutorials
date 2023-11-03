package com.example.doanswermethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@SpringBootTest
class DoAnswerMethodApplicationTests {

    @Test
    void testDoAnswer() {
        Database mockDatabase = mock(Database.class);

        // triển khai lgoic
        doAnswer(invocation -> {
            String data = invocation.getArgument(0);
            Callback callback = invocation.getArgument(1);

            if("validData".equals(data)) {
                callback.onSuccess();
            } else {
                callback.onFailure("invalid Data");
            }
            // vì phương thức save không trả về gì
            return null;
        }).when(mockDatabase).save("validData", new Callback() {
            @Override
            public void onSuccess() {
                System.out.println("Data saved successfully");
            }

            @Override
            public void onFailure(String reason) {
                System.out.println("data saving failed: " + reason);
            }
        });

        // invoke method
        mockDatabase.save("validData", new Callback() {
            @Override
            public void onSuccess() {
                System.out.println("Data saved successfully");
            }

            @Override
            public void onFailure(String reason) {
                System.out.println("data saving failed: " + reason);
            }
        });
    }
}
