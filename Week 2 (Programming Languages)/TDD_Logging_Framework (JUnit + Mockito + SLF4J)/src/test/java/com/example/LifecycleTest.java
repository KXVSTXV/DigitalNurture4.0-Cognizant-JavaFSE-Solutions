package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LifecycleTest {
    private int a;
    private int b;

    @Before
    public void setUp() {
        // Arrange: initialize before each test
        a = 5;
        b = 3;
        System.out.println("Setup complete");
    }

    @After
    public void tearDown() {
        // Cleanup after each test
        System.out.println("Teardown complete");
    }

    @Test
    public void testAddition() {
        // Act
        int result = a + b;

        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        // Act
        int result = a - b;

        // Assert
        assertEquals(2, result);
    }
}