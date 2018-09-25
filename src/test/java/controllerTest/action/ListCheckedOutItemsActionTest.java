package controllerTest.action;

import common.Message;
import controller.MainMenu;
import model.library.*;
import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListCheckedOutItemsActionTest {

    Collection<String> bookDetails;
    Collection<String> expected;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    UserAction userAction;
    User user;
    Book theHobbit;
    Movie shawshankRedemption;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        user = new User("123-4567", "Arpan");

        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        shawshankRedemption = new Movie("Shawshank Redemption", "Frank Darabont", 10, 1994);

        userAction.logIn(user);
    }

    @DisplayName("should print correct checked out book item list")
    @Test
    void shouldPrintCorrectCheckedOutBookList() {
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);

        MainMenu.LIST_CHECKED_OUT_ITEMS.perform(library, inputDriver, outputDriver, userAction);
        expected = new ArrayList<>(Arrays.asList(theHobbit.toString()));

        verify(outputDriver).printList(expected,ItemType.BOOK.getItemHeaders());
    }

    @DisplayName("should print correct checked out item list")
    @Test
    void shouldPrintCorrectCheckedOutMovieList() {
        when(inputDriver.getUserInput()).thenReturn("Shawshank Redemption");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_CHECKOUT);

        MainMenu.LIST_CHECKED_OUT_ITEMS.perform(library, inputDriver, outputDriver, userAction);
        expected = new ArrayList<>(Arrays.asList(shawshankRedemption.toString()));

        verify(outputDriver).printList(expected,ItemType.MOVIE.getItemHeaders());
    }

}