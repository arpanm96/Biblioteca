package controllerTest;

import common.Message;
import controller.LibraryManagementSystem;
import controller.MainMenu;
import model.library.LibraryItemRepository;
import model.library.Library;
import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    public static final int QUIT_VALUE = MainMenu.values().length;
    //public static final int QUIT_VALUE = 9;
    UserAction userAction;
    OutputDriver outputDriver;
    InputDriver inputDriver;
    Library library;
    LibraryManagementSystem libraryManagementSystem;
    User user;

    @BeforeEach
    void initEach(){
        user = new User("123-4567", "Arpan","a@gmail.com", 12345);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());;
        library = new Library( new LibraryItemRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library, userAction);
    }

    @DisplayName("should call the implicit functions of start")
    @Test
    void shouldCallImplicitFunctionsOfStart() {
        libraryManagementSystem.start();
        verify(outputDriver).printWelcomeMessage();
    }

    @DisplayName("should call the invalid choice on wrong input")
    @Test
    void shouldCallInvalidMenuChoiceFunction() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(40).thenReturn(QUIT_VALUE);
        libraryManagementSystem.operateMainMenu();
        verify(inputDriver,times(2)).getMenuChoiceFromUser();
        verify(outputDriver).print(Message.INVALID_INPUT);
    }

    @DisplayName("should call the implicit functions of display Menu for input given as 7 i.e quit")
    @Test
    void shouldCallImplicitFunctionsOfMenuFor1Input() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(QUIT_VALUE);
        libraryManagementSystem.operateMainMenu();
        verify(inputDriver).getMenuChoiceFromUser();
    }

    @DisplayName("should call the implicit functions of display Menu for listing menu i.e 1")
    @Test
    void shouldCallImplicitFunctionsOfMenuForListMenu() {
        when(inputDriver.getMenuChoiceFromUser()).thenReturn(1).thenReturn(QUIT_VALUE);
        libraryManagementSystem.operateMainMenu();
        verify(inputDriver,times(2)).getMenuChoiceFromUser();
        verify(outputDriver,times(2)).printMainMenu(libraryManagementSystem.getValidMenuCollection(userAction));
    }

    @DisplayName("should know who has checked out The Hobbit book")
    @Test
    void shouldKnowWhoHasCheckedOutTheHobbit() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);

    }
}

