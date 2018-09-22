/*
import controller.LibraryManagementSystem;
import model.Book;
import model.BookRepository;
import model.Library;
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
    Collection<Book> bookList;
    Collection<Book> expectedListAfterCheckout;
    Collection<Book> expectedListAfterReturn;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void initEach() {
        inputMockDriver = new InputDriver();
        outputMockDriver = mock(OutputDriver.class);

        booksMock1 = mock(Book.class);
        booksMock2 = mock(Book.class);

        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);

        library =  new Library( new BookRepository().generateDefaultItemList());
        libraryManagementSystem = new LibraryManagementSystem(inputMockDriver, outputMockDriver, library);
    }

    @DisplayName("Should get the default library book list correctly")
    @Test
    void shouldGetDefaultLibraryBookList() {
        assertEquals(library.getLibraryItemDetails(), new ArrayList<>(Arrays.asList("The Hobbit,Tolkien,1937", "The Lord Of The Rings,Tolkien,1954")));
    }

    @DisplayName("remove The Hobbit book")
    @Test
    void shouldRemoveTheHobbitBook() {
        bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(bookList);
        expectedListAfterCheckout = new ArrayList<>(Arrays.asList(theLordOfTheRings));

        assertAll(() -> {
            assertTrue(library.checkoutBook(theHobbit));
            assertEquals(expectedListAfterCheckout, bookList);
        });
    }

    @DisplayName("checkout The Lord Of The Rings book")
    @Test
    void shouldCheckoutTheLordOfTheRingsBook() {
        bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(bookList);
        expectedListAfterCheckout = new ArrayList<>(Arrays.asList(theHobbit));

        assertAll(() -> {
            assertTrue(library.checkoutBook(theLordOfTheRings));
            assertEquals(expectedListAfterCheckout, bookList);
        });
    }

    @DisplayName("should not checkout The Lord Of The Rings book")
    @Test
    void shouldNotCheckoutTheLordOfTheRingsBook() {
        bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(theHobbit));
        library = new Library(bookList);
        expectedListAfterCheckout = new ArrayList<>(Arrays.asList(theHobbit));

        assertAll(() -> {
            assertFalse(library.checkoutBook(theLordOfTheRings));
            assertEquals(expectedListAfterCheckout, bookList);
        });
    }

    @DisplayName("return The Hobbit book")
    @Test
    void shouldReturnTheHobbitBook() {
        bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(bookList);
        expectedListAfterReturn = new ArrayList<>(Arrays.asList(theLordOfTheRings, new Book("The Hobbit")));

        assertAll(() -> {
            assertTrue(library.checkoutBook(theHobbit));
            assertTrue(library.returnBook(new Book("The Hobbit")));
            assertEquals(expectedListAfterReturn, bookList);
        });
    }

    @DisplayName("return The Lord Of The Ring book")
    @Test
    void shouldReturnTheLordOfTheRingsBook() {
        bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(bookList);
        expectedListAfterReturn = new ArrayList<>(Arrays.asList(theHobbit, new Book("The Lord Of The Rings")));

        assertAll(() -> {
            assertTrue(library.checkoutBook(theLordOfTheRings));
            assertTrue(library.returnBook(new Book("The Lord Of The Rings")));
            assertEquals(expectedListAfterReturn, bookList);
        });
    }

    @DisplayName("should not return the already present The Lord Of The Ring book")
    @Test
    void shouldNotReturnTheLordOfTheRingsBook() {
        bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(theHobbit, theLordOfTheRings));
        library = new Library(bookList);
        expectedListAfterReturn = new ArrayList<>(Arrays.asList(theLordOfTheRings));

        assertAll(() -> {
            assertTrue(library.checkoutBook(theHobbit));
            assertFalse(library.returnBook(new Book("The Lord Of The Rings")));
            assertEquals(expectedListAfterReturn, bookList);
        });
    }
}
*/
