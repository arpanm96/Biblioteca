package controllerTest;

import controller.Action;
import controller.LibraryManagementSystem;
import controller.MainMenu;
import model.library.Library;
import model.user.UserAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MainMenuTest {

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    Action action;
    UserAction userAccount;
    LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library, userAccount);

    @BeforeEach
    void initEach() {
        action = mock(Action.class);
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAccount = mock(UserAction.class);
        libraryManagementSystem = mock(LibraryManagementSystem.class);
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
}
