import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputDriverTest {
    @DisplayName("expect 2 in the input stream")
    @Test
    void testMenuInput() {
        setSystemIn("2\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals(2, inputDriver.getMenuChoiceFromUser());
    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    void setup() {
        System.setIn(System.in);
    }
}
