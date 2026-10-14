
package com.codewithkanye;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldAddTwoNumbers() {
        assertEquals(10, calculator.add(4, 6));
    }

    @Test
    void shouldSubtractTwoNumbers() {
        assertEquals(4, calculator.subtract(9, 5));
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        assertEquals(24, calculator.multiply(4, 6));
    }

    @Test
    void shouldIdentifyPositiveNumbers() {
        assertTrue(calculator.isPositive(5));
    }

    @Test
    void shouldRejectZeroAsPositive() {
        assertFalse(calculator.isPositive(0));
    }

    @Test
    void shouldRejectNegativeNumbersAsPositive() {
        assertFalse(calculator.isPositive(-5));
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        assertThrows(
            ArithmeticException.class,
            () -> calculator.divide(10, 0)
        );
    }
}
