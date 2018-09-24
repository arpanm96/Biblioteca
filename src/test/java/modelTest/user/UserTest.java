package modelTest.user;

import controller.LibraryManagementSystem;
import model.library.*;
import model.user.UserAction;
import model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserTest {

    Book theHobbit;
    Book theLordOfTheRings;

    InputDriver inputMockDriver;
    OutputDriver outputMockDriver;
    Library library;
    LibraryManagementSystem libraryManagementSystem;
    UserAction userAction;
    User user;

    @BeforeEach
    void initEach() {
        inputMockDriver = new InputDriver();
        outputMockDriver = mock(OutputDriver.class);

        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);

        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputMockDriver, outputMockDriver, library, userAction);

        userAction = mock(UserAction.class);
        user = mock(User.class);
        userAction.logIn(user);
    }

    @DisplayName("should update theHobbit in the checkedOut list of the user")
    @Test
    void shouldUpdateTheHobbitBookToTheUserCheckoutList() {
        when(userAction.getCurrentlyLoggedInUser()).thenReturn(user);
        library.checkoutItem(theHobbit, userAction);
        verify(user).updateUserCheckoutItemList(theHobbit, CheckoutType.CHECKOUT);
    }

    @DisplayName("should update theHobbit in the checkedOut list of the user after checkout")
    @Test
    void shouldUpdateTheHobbitBookToTheUserCheckoutListAfterCheckout() {
        when(userAction.getCurrentlyLoggedInUser()).thenReturn(user);
        assertTrue(library.checkoutItem(theHobbit, userAction));
        verify(user).updateUserCheckoutItemList(theHobbit, CheckoutType.CHECKOUT);

        when(userAction.getCurrentlyLoggedInUser()).thenReturn(user);
        assertTrue(library.returnItem(theHobbit, userAction));
        verify(user).updateUserCheckoutItemList(theHobbit, CheckoutType.RETURN);
    }

    @DisplayName("should not update the lord of the ring book in the checkedOut list of the user after checkout")
    @Test
    void shouldNotRemoveTheLordOfTheRingsBookFromTheUserCheckoutListAfterCheckout() {
        when(userAction.getCurrentlyLoggedInUser()).thenReturn(user);
        assertTrue(library.checkoutItem(theHobbit, userAction));
        verify(user).updateUserCheckoutItemList(theHobbit, CheckoutType.CHECKOUT);

        when(userAction.getCurrentlyLoggedInUser()).thenReturn(user);
        assertFalse(library.returnItem(theLordOfTheRings, userAction));
    }
}
