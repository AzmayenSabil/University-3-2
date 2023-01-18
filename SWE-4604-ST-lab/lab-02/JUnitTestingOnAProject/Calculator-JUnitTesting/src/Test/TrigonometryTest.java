package Test;

import Main.Trigonometry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrigonometryTest {

    @Test
    public void testSine() {
        Trigonometry trigonometry = new Trigonometry();
        double result = trigonometry.sine(Math.PI / 2);
        assertEquals(1, result, 0.001);
    }

    @Test
    public void testCosine() {
        Trigonometry trigonometry = new Trigonometry();
        double result = trigonometry.cosine(Math.PI);
        assertEquals(-1, result, 0.001);
    }

    @Test
    public void testTangent() {
        Trigonometry trigonometry = new Trigonometry();
        double result = trigonometry.tangent(Math.PI / 4);
        assertEquals(1, result, 0.001);
    }
}