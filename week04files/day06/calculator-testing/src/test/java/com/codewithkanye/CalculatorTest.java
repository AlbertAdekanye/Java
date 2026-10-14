
package com.codewithkanye;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

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
    void shouldThrowExceptionWhenDividingByZero() {
        assertThrows(
            ArithmeticException.class,
            () -> calculator.divide(10, 0)
        );
    }
}
