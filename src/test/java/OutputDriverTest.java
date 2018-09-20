import controller.LibraryManagementSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Book;
import model.Library;
import view.OutputDriver;

import java.util.*;

import static org.mockito.Mockito.*;


class OutputDriverTest {

    OutputDriver outputMockDriver;
    Library library;
    Collection<Book> booksList;
    LibraryManagementSystem libraryManagementSystem;
    @BeforeEach
     void initEach() {
        outputMockDriver = mock(OutputDriver.class);
        Book booksMock1 = mock(Book.class);
        Book booksMock2 = mock(Book.class);
        booksList = new ArrayList<>(Arrays.asList(booksMock1, booksMock2));
        Library library = new Library();
        libraryManagementSystem = new LibraryManagementSystem();
    }

    @Disabled
    @DisplayName("Should expect call to print the message")
    @Test
    void shouldPrintWelcomeToBiblioteca() {
        verify(outputMockDriver).printWelcomeMessage();
    }

    @Disabled
    @DisplayName("should display the list of books correctly")
    @Test
    void shouldDisplayBookListCorrectly() {
        //outputMockDriver.printBookList();
    }
}
