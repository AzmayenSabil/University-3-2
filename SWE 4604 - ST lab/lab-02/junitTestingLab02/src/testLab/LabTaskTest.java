package testLab;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LabTaskTest {
    LabTask task = new LabTask();

    @Test
    @DisplayName("Add two numbers")
    void add() {
        assertEquals(4, task.addition(2, 2));
    }

    @Test
    void checkNegativeNumber(){
        assertEquals(false, task.checkRangeOfNumber(-1L));
    }

    @Test
    void checkOutOfRangeNumber(){
        assertEquals(false, task.checkRangeOfNumber(10000000000000L));
    }

    @Test
    void checkPrime(){
        assertEquals(true, task.checkPrime(3L));
    }

    @Test
    void checkNotPrime(){
        assertEquals(false, task.checkPrime(1000000000000L));
    }

    @Test
    public void outOfRangeException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            LabTask task = new LabTask();
            task.checkRangeOfNumberWithException(-1L);
        });

        assertEquals("Number is less than 2 or greater than 1000000000000", exception.getMessage());
    }

}
