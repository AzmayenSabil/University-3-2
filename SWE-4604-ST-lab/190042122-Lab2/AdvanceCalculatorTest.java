package Test;

import Main.AdvanceCalculator;
import Main.Calculator;
import Main.ICalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvanceCalculatorTest {

    @Test
    public void testModulo() {
        AdvanceCalculator calculator = new AdvanceCalculator(5, 3);
        double result = calculator.modulo();
        assertEquals(2, result);
    }

    @Test
    public void testModuloByZero(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            AdvanceCalculator calculator = new AdvanceCalculator(5, 0);
            double result = calculator.modulo();
        });

        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    public void testPower() {
        AdvanceCalculator calculator = new AdvanceCalculator(5, 3);
        double result = calculator.power();
        assertEquals(125, result);
    }

    @Test
    public void testSquareRoot() {
        AdvanceCalculator calculator = new AdvanceCalculator(9, 0);
        double result = calculator.squareRoot();
        assertEquals(3, result);
    }

    @Test
    public void testSquareRootOfNegativeNumber() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            AdvanceCalculator calculator = new AdvanceCalculator(-2, 0);
            double result = calculator.squareRoot();
        });

        assertEquals("Cannot take square root of negative number.", exception.getMessage());
    }
}