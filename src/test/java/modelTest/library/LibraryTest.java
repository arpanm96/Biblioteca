package modelTest.library;

import controller.LibraryManagementSystem;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LibraryTest {
    Book booksMock1;
    Book booksMock2;
    Book theHobbit;
    Book theLordOfTheRings;

    InputDriver inputMockDriver;
    OutputDriver outputMockDriver;
    Library library;
    Collection<Item> itemCollection;
    Collection<Item> expectedListAfterCheckout;
    Collection<Item> expectedListAfterReturn;
    LibraryManagementSystem libraryManagementSystem;
    UserAction userAction;
    User user;

    @BeforeEach
    void initEach() {
        inputMockDriver = new InputDriver();
        outputMockDriver = mock(OutputDriver.class);
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());;

        booksMock1 = mock(Book.class);
        booksMock2 = mock(Book.class);

        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);

        library =  new Library( new LibraryItemRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputMockDriver, outputMockDriver, library, userAction);

        user = new User("123-4567", "Arpan");
        userAction.logIn(user);
    }

    @DisplayName("Should get the default library book list correctly")
    @Test
    void shouldGetDefaultLibraryBookList() {
        assertEquals(library.getLibraryItemDetails(ItemType.BOOK), new ArrayList<>(Arrays.asList("The Hobbit,Tolkien,1937", "The Lord Of The Rings,Tolkien,1954")));
    }

    @DisplayName("remove The Hobbit book")
    @Test
    void shouldRemoveTheHobbitBook() {
        itemCollection = new ArrayList<>();
        itemCollection.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(itemCollection);
        expectedListAfterCheckout = new ArrayList<>(Arrays.asList(theLordOfTheRings));

        assertAll(() -> {
            assertTrue(library.checkoutItem(theHobbit, userAction));
            //assertEquals(expectedListAfterCheckout, itemCollection);
        });
    }

    @DisplayName("checkout The Lord Of The Rings book")
    @Test
    void shouldCheckoutTheLordOfTheRingsBook() {
        itemCollection = new ArrayList<>();
        itemCollection.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(itemCollection);
        expectedListAfterCheckout = new ArrayList<>(Arrays.asList(theHobbit));

        assertAll(() -> {
            assertTrue(library.checkoutItem(theLordOfTheRings, userAction));
            assertEquals(expectedListAfterCheckout, itemCollection);
        });
    }

    @DisplayName("should not checkout The Lord Of The Rings book")
    @Test
    void shouldNotCheckoutTheLordOfTheRingsBook() {
        itemCollection = new ArrayList<>();
        itemCollection.addAll(Arrays.asList(theHobbit));
        library = new Library(itemCollection);
        expectedListAfterCheckout = new ArrayList<>(Arrays.asList(theHobbit));

        assertAll(() -> {
            assertFalse(library.checkoutItem(theLordOfTheRings, userAction));
            assertEquals(expectedListAfterCheckout, itemCollection);
        });
    }

    @DisplayName("return The Hobbit book")
    @Test
    void shouldReturnTheHobbitBook() {
        itemCollection = new ArrayList<>();
        itemCollection.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(itemCollection);
        expectedListAfterReturn = new ArrayList<>(Arrays.asList(theLordOfTheRings, new Book("The Hobbit")));

        assertAll(() -> {
            assertTrue(library.checkoutItem(theHobbit, userAction));
            assertTrue(library.returnItem(new Book("The Hobbit"), userAction));
            assertEquals(expectedListAfterReturn, itemCollection);
        });
    }

    @DisplayName("return The Lord Of The Ring book")
    @Test
    void shouldReturnTheLordOfTheRingsBook() {
        itemCollection = new ArrayList<>();
        itemCollection.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(itemCollection);
        expectedListAfterReturn = new ArrayList<>(Arrays.asList(theHobbit, new Book("The Lord Of The Rings")));

        assertAll(() -> {
            assertTrue(library.checkoutItem(theLordOfTheRings, userAction));
            assertTrue(library.returnItem(new Book("The Lord Of The Rings"), userAction));
            assertEquals(expectedListAfterReturn, itemCollection);
        });
    }

    @DisplayName("should not return the already present The Lord Of The Ring book")
    @Test
    void shouldNotReturnTheLordOfTheRingsBook() {
        itemCollection = new ArrayList<>();
        itemCollection.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(itemCollection);
        expectedListAfterReturn = new ArrayList<>(Arrays.asList(theLordOfTheRings));

        assertAll(() -> {
            assertTrue(library.checkoutItem(theHobbit, userAction));
            assertFalse(library.returnItem(new Book("The Lord Of The Rings"), userAction));
            assertEquals(expectedListAfterReturn, itemCollection);
        });
    }
}
