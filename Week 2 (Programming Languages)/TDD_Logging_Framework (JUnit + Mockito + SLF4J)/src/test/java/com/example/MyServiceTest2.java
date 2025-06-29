package com.example;

import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyServiceTest2 {

    @Test
    public void testVerifyInteraction() {
        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert
        verify(mockApi).getData();  // This checks if getData() was called exactly once
    }
}