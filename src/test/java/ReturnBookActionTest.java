
import controller.MainMenu;
import model.Book;
import model.BookRepository;
import model.ItemType;
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

public class ReturnBookActionTest {
    Book theHobbit;
    Book theLordOfTheRings;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = new Library(new BookRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("should not return back an already present book")
    @Test
    void shouldNotReturnBook() {
        when(inputDriver.getBookToBeCheckedOut()).thenReturn("The Lord Of The Rings");
        MainMenu.CHECKOUT.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getBookToBeCheckedOut();
        verify(outputDriver).printBookCheckedOut();

        when(inputDriver.getBookToBeReturned()).thenReturn("The Hobbit");
        MainMenu.RETURN_BOOK.perform(library, inputDriver, outputDriver);
        verify(outputDriver).printBookNotReturned();
    }

    @DisplayName("should return back a checked out book")
    @Test
    void shouldReturnBook() {
        when(inputDriver.getBookToBeCheckedOut()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getBookToBeCheckedOut();
        verify(outputDriver).printBookCheckedOut();


        when(inputDriver.getBookToBeReturned()).thenReturn("The Hobbit");
        MainMenu.RETURN_BOOK.perform(library, inputDriver, outputDriver);
        verify(outputDriver).printBookReturned();
    }
}