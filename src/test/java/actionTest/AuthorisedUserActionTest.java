package actionTest;

import common.Message;
import controller.MainMenu;
import model.library.Book;
import model.library.ItemType;
import model.library.Library;
import model.library.LibraryItemRepository;
import model.user.User;
import model.user.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthorisedUserActionTest {

    Book theHobbit;
    Book theLordOfTheRings;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    UserAccount userAccount;
    User user;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAccount = new UserAccount();
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
        user = new User("123-4567", "Arpan");
    }

    @DisplayName("Should checkout if user is logged in")
    @Test
    void checkoutBookOnlyIfLoggedIn() {
        userAccount.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAccount);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);
    }

    @DisplayName("Should not checkout if user is not logged in even though the book is present and will ask to login")
    @Test
    void willNotCheckoutBookOnlyIfNotLoggedIn() {
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAccount);
        verify(outputDriver).print(Message.PLEASE_LOG_IN);
    }
}
