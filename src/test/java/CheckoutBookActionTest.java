import common.Message;
import controller.MainMenu;
import model.Book;
import model.LibraryItemRepository;
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

class CheckoutBookActionTest {

    Book theHobbit;
    Book theLordOfTheRings;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("verify book is not checked out")
    @Test
    void shouldNotCheckoutBook() {
        when(inputDriver.getUserInput()).thenReturn("A Random Book");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.UNSUCCESSFUL_BOOK_CHECKOUT);
    }

    @DisplayName("verify book is checked out")
    @Test
    void shouldCheckoutBook() {
        when(inputDriver.getUserInput()).thenReturn("The Hobbit");
        MainMenu.CHECKOUT_BOOK.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_BOOK_CHECKOUT);
    }
}
