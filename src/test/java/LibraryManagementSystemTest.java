import controller.LibraryManagementSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    OutputDriver outputDriver;
    InputDriver inputDriver;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void initEach(){
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver);
    }

    @DisplayName("should call the implicit functions of start")
    @Test
    void shouldCallImplicitFunctionsOfStart() {
        libraryManagementSystem.start();
        verify(outputDriver).printWelcomeMessage();
        verify(outputDriver).printMainMenu();
    }

    @DisplayName("should call the implicit functions of display Menu")
    @Test
    void shouldCallImplicitFunctionsOfMenu() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(2).thenReturn(3).thenReturn(1);
        libraryManagementSystem.performOnMenuChoice();
        verify(inputDriver,times(3)).getMenuChoiceFromUser();
        verify(outputDriver).printInvalidMenuChoice();
    }
}
