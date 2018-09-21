import controller.LibraryManagementSystem;
import model.Book;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    Collection<Book> expectedList;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void initEach() {
        inputMockDriver = new InputDriver();
        outputMockDriver = mock(OutputDriver.class);
        booksMock1 = mock(Book.class);
        booksMock2 = mock(Book.class);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);

        bookList = new ArrayList<>();
        expectedList = new ArrayList<>(Arrays.asList(theLordOfTheRings));
        bookList.addAll(Arrays.asList(theHobbit, theLordOfTheRings));

        library = new Library(bookList);
        libraryManagementSystem = new LibraryManagementSystem(inputMockDriver, outputMockDriver);
    }

    @DisplayName("Should get the default library book list correctly")
    @Test
    void shouldGetDefaultLibraryBookList() {
        assertEquals(new Library().getLibraryBookDetails(), new ArrayList<>(Arrays.asList("The Hobbit | Tolkien | 1937", "The Lord Of The Rings | Tolkien | 1954")));
    }

    @DisplayName("remove The Hobbit book")
    @Test
    void shouldRemoveTheHobbitBook() {
        assertTrue(library.checkoutBook(theHobbit));
        assertEquals(expectedList, bookList);
    }

    @DisplayName("add The Hobbit book")
    @Test
    void shouldAddTheHobbitBook() {
        library.returnBook(new Book("The Hobbit"));
        assertEquals(expectedList, bookList);
    }
}
