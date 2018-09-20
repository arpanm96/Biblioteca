import controller.LibraryManagementSystem;
import model.Book;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LibraryTest {
    Book booksMock1;
    Book booksMock2;
    Book theHobbit;
    Book theLordOfTheRings;

    OutputDriver outputMockDriver;
    Library library;
    Collection<Book> bookList;
    Collection<Book> expectedList;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void initEach() {
        outputMockDriver = mock(OutputDriver.class);
        booksMock1 = mock(Book.class);
        booksMock2 = mock(Book.class);
        theHobbit = new Book("The Hobbit");
        theLordOfTheRings = new Book("The Lord Of The Rings");

        bookList = new ArrayList<>();
        expectedList = new ArrayList<>();
        bookList.addAll(Arrays.asList(theHobbit,theLordOfTheRings));

        library = new Library(bookList);
        libraryManagementSystem = new LibraryManagementSystem(outputMockDriver);
    }

    @DisplayName("Should print library book list correctly")
    @Test
    void shouldPrintLibraryBookList() {
        assertEquals(new Library().toString(),library.toString());
    }
}
