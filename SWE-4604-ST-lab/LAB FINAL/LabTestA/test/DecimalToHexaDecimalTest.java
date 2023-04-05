import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToHexaDecimalTest {

    @Test
    void decToHex() {
        String ans  = DecimalToHexaDecimal.decToHex(10);
        assertEquals("a", ans);
    }

    @Test
    void checkNegative(){
        String ans = DecimalToHexaDecimal.decToHex(-123);
        assertEquals("-7b",ans);
    }

    @Test
    void checkSingleIntegarAsInput(){
        String ans = DecimalToHexaDecimal.decToHex(1);
        assertEquals("1", ans);
    }

    @Test
    void checkForOtherInput(){
        String ans = DecimalToHexaDecimal.decToHex(0);
        //unfinished
    }

    @Test
    void checkDecimalPointInput(){
        String ans = DecimalToHexaDecimal.decToHex((int)174.625);
        assertEquals("AE.A", ans);
    }
}