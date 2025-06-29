package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*; // JUnit 4 assertion
import org.junit.Test;            // JUnit 4 test
import org.mockito.Mockito;

// Simulated external API
interface ExternalApi {
    String getData();
}

// Service depending on the external API
class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}

public class MyServiceTest {
    @Test
    public void testExternalApi() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        // Act
        String result = service.fetchData();

        // Assert
        assertEquals("Mock Data", result);
    }
}