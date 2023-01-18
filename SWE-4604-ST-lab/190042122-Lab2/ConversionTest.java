package Test;

import Main.Conversion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {

    @Test
    public void testFeetToMeters() {
        Conversion conversion = new Conversion();
        double result = conversion.feetToMeters(5);
        assertEquals(1.524, result, 0.001);
    }

    @Test
    public void testMetersToFeet() {
        Conversion conversion = new Conversion();
        double result = conversion.metersToFeet(5);
        assertEquals(16.404, result, 0.001);
    }
}