package controllerTest.action;

import common.Message;
import controller.MainMenu;
import model.library.ItemType;
import model.library.Library;
import model.library.LibraryItemRepository;
import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.*;

/*
Some of the tests are disabled because it was written earlier when the all the menus were
displayed together and the user had to be logged in to access those menus.
 */

public class AuthorisedUserActionTest {

    Collection<String> bookDetails;
    Collection<String> movieDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    UserAction userAction;
    User user;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        user = new User("123-4567", "Arpan");
        movieDetails = library.getLibraryItemDetails(ItemType.MOVIE);
    }

    @DisplayName("Should checkout book if user is logged in")
    @Test
    void checkoutBookOnlyIfLoggedIn() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);
    }

    @Disabled
    @DisplayName("Should not checkout book if user is not logged in even though the book is present and will ask to login")
    @Test
    void willNotCheckoutBookOnlyIfNotLoggedIn() {
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.PLEASE_LOG_IN);
    }

    @DisplayName("Should checkout movie if user is logged in")
    @Test
    void checkoutMovieOnlyIfLoggedIn() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("Shawshank Redemption");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_CHECKOUT);
    }

    @Disabled
    @DisplayName("Should not checkout movie if user is not logged in")
    @Test
    void willNotCheckoutMovieOnlyIfNotLoggedIn() {
        when(inputDriver.getUserInput()).thenReturn("Shawshank Redemption");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.PLEASE_LOG_IN);
    }

    @DisplayName("Should return book if user is logged in")
    @Test
    void shouldReturnBookOnlyIfTheUserIsLoggedIn() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);


        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.RETURN_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_RETURN);
    }

    @Disabled
    @DisplayName("Should not return book if user is not logged in")
    @Test
    void shouldNotReturnBookIfTheUserIsNotLoggedIn() {
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.PLEASE_LOG_IN);


        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.RETURN_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver,times(2)).print(Message.PLEASE_LOG_IN);
    }

    @DisplayName("should return back a checked out movie")
    @Test
    void shouldReturnMovie() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("Se7en");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_CHECKOUT);


        when(inputDriver.getUserInput()).thenReturn("Se7en");
        MainMenu.RETURN_MOVIE.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_RETURN);
    }

    @Disabled
    @DisplayName("should return back a checked out movie")
    @Test
    void shouldNotReturnMovieIfUserIsNotLoggedIn() {
        when(inputDriver.getUserInput()).thenReturn("Se7en");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.PLEASE_LOG_IN);


        when(inputDriver.getUserInput()).thenReturn("Se7en");
        MainMenu.RETURN_MOVIE.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver,times(2)).print(Message.PLEASE_LOG_IN);
    }

}