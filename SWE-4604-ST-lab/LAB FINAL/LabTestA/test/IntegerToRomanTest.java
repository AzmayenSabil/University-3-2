import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

    @Test
    void integerToRoman() {
        String ans = IntegerToRoman.integerToRoman(2);
        assertEquals("II", ans);
    }

    @Test
    void checkLargeInteger(){
        String ans = IntegerToRoman.integerToRoman(1000000000);
        assertEquals(1,0);
    }

    @Test
    void checkNegativeNumber(){
        String ans = IntegerToRoman.integerToRoman(-45);
        assertEquals("XLXLXLVVV", ans);
    }

}