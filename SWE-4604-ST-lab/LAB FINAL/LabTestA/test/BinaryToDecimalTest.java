import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToDecimalTest {

    @Test
    void checkBinary(){
        long ans = BinaryToDecimal.binaryToDecimal(101);
        assertEquals(5, ans);
    }

    @Test
    void checkForDashSign(){
        long input = 101;
        long ans = BinaryToDecimal.binaryToDecimal(input);
        boolean rightInput = false;

        if(input >= 0){
            rightInput = true;
        }

        assertTrue(rightInput);
    }

    @Test
    void checkNumberWithOnlyZero(){
        long ans = BinaryToDecimal.binaryToDecimal(0);
        assertEquals(0, ans);
    }

    @Test
    void checkBinWithOtherDigits(){
        long ans = BinaryToDecimal.binaryToDecimal(22);
        assertEquals(6, ans);
    }

    @Test
    void checkPaddedZeroBin(){
        long ans = BinaryToDecimal.binaryToDecimal(00101);
        assertEquals(5, ans);
    }

    @Test
    void checkDecimalPoint(){
        long ans = BinaryToDecimal.binaryToDecimal((long)110.101);
        assertEquals(6.625, ans);
    }

}