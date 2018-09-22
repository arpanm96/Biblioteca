import controller.MainMenu;
import model.Book;
import model.BookRepository;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutBookActionTest {

    Book theHobbit;
    Book theLordOfTheRings;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = new Library(new BookRepository().generateDefaultBookList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        bookDetails = library.getLibraryBookDetails();
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("verify book is not checked out")
    @Test
    void shouldNotCheckoutBook() {
        when(inputDriver.getBookToBeCheckedOut()).thenReturn("A Random Book");
        MainMenu.CHECKOUT.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getBookToBeCheckedOut();
        verify(outputDriver).printBookNotCheckedOut();
    }

    @DisplayName("verify book is checked out")
    @Test
    void shouldCheckoutBook() {
        when(inputDriver.getBookToBeCheckedOut()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getBookToBeCheckedOut();
        verify(outputDriver).printBookCheckedOut();
    }
}
