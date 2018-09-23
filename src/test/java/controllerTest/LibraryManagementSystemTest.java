package controllerTest;

import common.Message;
import controller.LibraryManagementSystem;
import controller.MainMenu;
import model.library.LibraryItemRepository;
import model.library.Library;
import model.user.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    public static final int QUIT_VALUE = MainMenu.values().length;
    UserAccount userAccount;
    OutputDriver outputDriver;
    InputDriver inputDriver;
    Library library;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void initEach(){
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAccount = new UserAccount();;
        library = new Library( new LibraryItemRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library, userAccount);
    }

    @DisplayName("should call the implicit functions of start")
    @Test
    void shouldCallImplicitFunctionsOfStart() {
        libraryManagementSystem.start();
        verify(outputDriver).printWelcomeMessage();
        verify(outputDriver).printMainMenu();
    }

    //@Disabled
    @DisplayName("should call the invalid choice on wrong input")
    @Test
    void shouldCallInvalidMenuChoiceFunction() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(40).thenReturn(QUIT_VALUE);
        libraryManagementSystem.performOnMenuChoice();
        verify(inputDriver,times(2)).getMenuChoiceFromUser();
        verify(outputDriver).print(Message.INVALID_INPUT);
    }

    @DisplayName("should call the implicit functions of display Menu for input given as 7 i.e quit")
    @Test
    void shouldCallImplicitFunctionsOfMenuFor1Input() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(QUIT_VALUE);
        libraryManagementSystem.performOnMenuChoice();
        verify(inputDriver).getMenuChoiceFromUser();
    }

    @DisplayName("should call the implicit functions of display Menu for listing menu i.e 1")
    @Test
    void shouldCallImplicitFunctionsOfMenuForListMenu() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(1).thenReturn(QUIT_VALUE);
        libraryManagementSystem.performOnMenuChoice();
        verify(inputDriver,times(2)).getMenuChoiceFromUser();
        verify(outputDriver).printMainMenu();
    }

}

