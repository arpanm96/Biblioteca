import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


class OutputDriverTest {

    OutputDriver outputMockDriver;
    Library library;
    List<Books> booksList;
    @BeforeEach
     void initEach() {
        outputMockDriver = mock(OutputDriver.class);
        Books booksMock1 = mock(Books.class);
        Books booksMock2 = mock(Books.class);
        booksList = new ArrayList<>(Arrays.asList(booksMock1, booksMock2));
        Library library = new Library(outputMockDriver, booksList);

    }
    @DisplayName("Should expect call to print the message")
    @Test
    void shouldPrintWelcomeToBiblioteca() {
        verify(outputMockDriver).printWelcomeMessage("Welcome To Biblioteca");
    }
    @DisplayName("should display the list of books correctly")
    @Test
    void shouldDisplayBooksListCorrectly() {
        verify(outputMockDriver).printBookList(booksList);
    }
}
