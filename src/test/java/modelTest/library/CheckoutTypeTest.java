package modelTest.library;

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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutTypeTest {

    User user;
    Book theHobbit;
    CheckoutType checkoutType;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    UserAction userAction;

    @BeforeEach
    void initEach() {
        user = new User("123-4567", "Arpan");
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        checkoutType = CheckoutType.CHECKOUT;

        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
    }
    @DisplayName("should add item to checked out list for user")
    @Test
    void shouldAddItemToCheckList() {
        userAction.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver, userAction);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);

    }
}
