package Test;

import Main.Calculator;
import Main.ICalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testAdd() {
        ICalculator calculator = new Calculator(5, 3);
        double result = calculator.add();
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        ICalculator calculator = new Calculator(5, 3);
        double result = calculator.subtract();
        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        ICalculator calculator = new Calculator(5, 3);
        double result = calculator.multiply();
        assertEquals(15, result);
    }

    @Test
    public void testDivide() {
        ICalculator calculator = new Calculator(6, 3);
        double result = calculator.divide();
        assertEquals(2, result);
    }

    @Test
    public void testDivideWithZero() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ICalculator calculator = new Calculator(6, 0);
            double result = calculator.divide();
        });

        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
}