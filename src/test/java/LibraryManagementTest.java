import controller.LibraryManagementSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryManagementTest {

    LibraryManagementSystem libraryManagementSystem;
    @BeforeEach
    void initEach(){
        libraryManagementSystem = new LibraryManagementSystem();
    }


    @DisplayName("should return true for input 1")
    @Test
    void shouldReturnTrueFor1() {
        assertTrue(libraryManagementSystem.isValidInput(1));
    }

    @DisplayName("should return true for input -3")
    @Test
    void shouldReturnFalseFor_3() {
        assertFalse(libraryManagementSystem.isValidInput(-3));
    }
    @DisplayName("should return true for input 10")
    @Test
    void shouldReturnFalseFor10() {
        assertFalse(libraryManagementSystem.isValidInput(10));
    }
}
