package Test;

import Main.UI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UITest {

    @Test
    public void testDisplayError() {
        UI ui = new UI();
        ui.displayError("Invalid input");
        assertEquals("Error: Invalid input", ui.generateMessage);
    }
}