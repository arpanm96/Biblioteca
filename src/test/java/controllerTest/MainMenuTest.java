package controllerTest;

import controller.Action;
import controller.LibraryManagementSystem;
import controller.MainMenu;
import model.library.Library;
import model.library.LibraryItemRepository;
import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MainMenuTest {

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    Action action;
    UserAction userAccount;
    User user;
    LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library, userAccount);

    @BeforeEach
    void initEach() {
        user = new User("123-4567","Arpan");
        action = mock(Action.class);
        library = new Library( new LibraryItemRepository().generateDefaultItemList());;
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAccount = new UserAction(new UserDetailsRepository().generateDefaultUserList());
        libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library, userAccount);
    }

    @DisplayName("should return the List Movie message")
    @Test
    void shouldReturnListMovieMessage() {
        assertEquals("List Movie", MainMenu.LIST_MOVIES.toString());
    }

    @DisplayName("should return the List Book message")
    @Test
    void shouldReturnListBookMessage() {
        assertEquals("List Books", MainMenu.LIST_BOOKS.toString());
    }

    @DisplayName("should return the Quit message")
    @Test
    void shouldReturnQuitMessage() {
        assertEquals("Quit", MainMenu.QUIT.toString());
    }

    @DisplayName("should return true for list book menu")
    @Test
    void shouldReturnTrueForListBooks() {
        assertTrue(MainMenu.LIST_BOOKS.isValidMenu(userAccount));
    }

    @DisplayName("should return true for checkout book menu since the user is not logged in")
    @Test
    void shouldReturnFalseForCheckoutBooks() {
        assertFalse(MainMenu.CHECKOUT_BOOK.isValidMenu(userAccount));
    }

    @DisplayName("should return true for checkout book menu since the user is logged in")
    @Test
    void shouldReturnTrueForCheckoutBookIfTheUserIsLoggedIn() {
        userAccount.logIn(user);
        assertTrue(userAccount.isUserLoggedIn());
        assertTrue(MainMenu.CHECKOUT_BOOK.isValidMenu(userAccount));
    }
}
