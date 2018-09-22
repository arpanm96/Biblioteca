
import controller.LibraryManagementSystem;
import model.LibraryItemRepository;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    OutputDriver outputDriver;
    InputDriver inputDriver;
    Library library;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void initEach(){
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        library = new Library( new LibraryItemRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library);
    }

    @DisplayName("should call the implicit functions of start")
    @Test
    void shouldCallImplicitFunctionsOfStart() {
        libraryManagementSystem.start();
        verify(outputDriver).printWelcomeMessage();
        verify(outputDriver).printMainMenu();
    }

    @Disabled
    @DisplayName("should call the implicit functions of display Menu for input given as 4 i.e quit")
    @Test
    void shouldCallImplicitFunctionsOfMenuFor1Input() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(4);
        libraryManagementSystem.performOnMenuChoice();
        verify(inputDriver).getMenuChoiceFromUser();
    }

/*    @DisplayName("should call the implicit functions of display Menu for input given as invalid i.e 96")
    @Test
    void shouldCallImplicitFunctionsOfMenuForInvalidInput() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(96).thenReturn(4);
        libraryManagementSystem.performOnMenuChoice();
        verify(inputDriver,times(2)).getMenuChoiceFromUser();
        verify(outputDriver).printInvalidMenuChoice();
    }

    @DisplayName("should call the implicit functions of display Menu for listing menu i.e 1")
    @Test
    void shouldCallImplicitFunctionsOfMenuForListMenu() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(1).thenReturn(4);
        libraryManagementSystem.performOnMenuChoice();
        verify(inputDriver,times(2)).getMenuChoiceFromUser();
    }*/

}

