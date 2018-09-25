package modelTest.user;

import controller.LibraryManagementSystem;
import model.library.*;
import model.user.UserAction;
import model.user.User;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserTest {

    Book theHobbit;
    Book theLordOfTheRings;

    InputDriver inputMockDriver;
    OutputDriver outputMockDriver;
    Library library;
    UserAction userAction;
    User user1;
    User user2;

    @BeforeEach
    void initEach() {
        inputMockDriver = new InputDriver();
        outputMockDriver = mock(OutputDriver.class);

        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);

        library = new Library(new LibraryItemRepository().generateDefaultItemList());

        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());

        user1 = new User("123-4567", "Arpan", "a@gmail.com", 12345);
        user2 = new User("234-5678", "Arpan", "b@gmail.com", 12345);

        userAction.logIn(user1);
    }

    @DisplayName("should print users correctly")
    @Test
    void shouldPrintUsersCorrectly() {
        assertEquals("123-4567,a@gmail.com,12345",user1.toString());
        assertEquals("234-5678,b@gmail.com,12345",user2.toString());
    }

    @DisplayName("should update theHobbit in the checkedOut list of the userMock")
    @Test
    void shouldUpdateTheHobbitBookToTheUserCheckoutList() {
        assertTrue(library.checkoutItem(theHobbit,userAction));
        ArrayList<Item> expectedList = new ArrayList<>(Arrays.asList(theHobbit));
        assertEquals(expectedList,userAction.getCurrentlyLoggedInUser().getCurrentCheckedOutItems());
    }


    @DisplayName("should delete theHobbit from the checkedOut list of the user after returning")
    @Test
    void shouldUpdateTheHobbitBookFromTheUserCheckoutListAfterReturn() {
        assertTrue(library.checkoutItem(theHobbit,userAction));
        ArrayList<Item> expectedList = new ArrayList<>(Arrays.asList(theHobbit));
        assertEquals(expectedList,userAction.getCurrentlyLoggedInUser().getCurrentCheckedOutItems());

        assertTrue(library.returnItem(theHobbit,userAction));
        assertEquals(new ArrayList<>(),userAction.getCurrentlyLoggedInUser().getCurrentCheckedOutItems());
    }

    @DisplayName("should not update the lord of the ring book in the checkedOut list of the user after checkout")
    @Test
    void shouldNotUpdateTheLordOfTheRingsBookToTheUserCheckoutListAfterCheckout() {
        assertTrue(library.checkoutItem(theHobbit,userAction));
        ArrayList<Item> expectedList = new ArrayList<>(Arrays.asList(theHobbit));
        assertEquals(expectedList,userAction.getCurrentlyLoggedInUser().getCurrentCheckedOutItems());

        assertFalse(library.returnItem(theLordOfTheRings,userAction));
        assertEquals(expectedList,userAction.getCurrentlyLoggedInUser().getCurrentCheckedOutItems());
    }
}
