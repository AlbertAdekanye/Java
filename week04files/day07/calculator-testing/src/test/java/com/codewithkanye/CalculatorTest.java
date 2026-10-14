
package com.codewithkanye;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void shouldAddNegativeAndPositiveNumbers() {
        assertEquals(0, calculator.add(-5, 5));
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
    void shouldDivideByTwoNumbers() {
        assertEquals(5, calculator.divide(20, 4));
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
