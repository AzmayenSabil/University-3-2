package Test;

import Main.History;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    @Test
    public void testAddCalculation() {
        History history = new History();
        history.addCalculation("5 + 3 = 8");
        assertEquals("5 + 3 = 8", history.history.get(0));
    }

    @Test
    public void testClearHistory() {
        History history = new History();
        history.addCalculation("5 + 3 = 8");
        history.clearHistory();
        assertEquals(0, history.getSize());
    }
}