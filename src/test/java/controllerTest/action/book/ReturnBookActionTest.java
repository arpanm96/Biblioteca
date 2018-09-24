package controllerTest.action.book;

import common.Message;
import controller.MainMenu;
import model.library.Book;
import model.library.LibraryItemRepository;
import model.library.ItemType;
import model.library.Library;
import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnBookActionTest {
    UserAction userAction;
    Book theHobbit;
    Book theLordOfTheRings;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    User user;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());;
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
        user = new User("123-4567", "Arpan");
    }

    @DisplayName("should not return back an already present book")
    @Test
    void shouldNotReturnBook() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Lord Of The Rings");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);

        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.RETURN_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.UNSUCCESSFUL_BOOK_RETURN);
    }

    @DisplayName("should return back a checked out book")
    @Test
    void shouldReturnBook() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);


        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.RETURN_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_RETURN);
    }
}