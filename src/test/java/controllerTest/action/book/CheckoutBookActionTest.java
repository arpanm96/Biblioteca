package controllerTest.action.book;

import common.Message;
import controller.MainMenu;
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

class CheckoutBookActionTest {

    Collection<String> bookDetails;

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
    }

    @DisplayName("verify book is not checked out")
    @Test
    void shouldNotCheckoutBook() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("A Random Book");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.UNSUCCESSFUL_BOOK_CHECKOUT);
    }

    @DisplayName("verify book is checked out")
    @Test
    void shouldCheckoutBook() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);
    }
}
