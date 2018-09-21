import controller.MainMenu;
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

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class MainMenuTest {

    Book booksMock1;
    Book booksMock2;
    Book theHobbit;
    Book theLordOfTheRings;
    Collection<Book> bookCollection;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        booksMock1 = mock(Book.class);
        booksMock2 = mock(Book.class);
        bookCollection = new ArrayList<>(Arrays.asList(booksMock1, booksMock2));
        bookDetails = library.getLibraryBookDetails();
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("verify act on menu list")
    @Test
    void actOnMenuList() {
        MainMenu.LIST_BOOKS.act(library, inputDriver, outputDriver);
        verify(outputDriver).printBookList(bookDetails);
        verify(library,times(2)).getLibraryBookDetails();
    }

    @DisplayName("verify act on checkout")
    @Test
    void actOnCheckout() {
        when(inputDriver.getBookToBeCheckedOut()).thenReturn("The Hobbit");
        Book checkoutBook = new Book("The Hobbit");
        MainMenu.CHECKOUT.act(library, inputDriver, outputDriver);
        verify(inputDriver).getBookToBeCheckedOut();
        verify(library).checkoutBook(checkoutBook);
    }

    @DisplayName("verify act on return book")
    @Test
    void actOnReturnBook() {
        when(inputDriver.getBookToBeReturned()).thenReturn("The Hobbit");
        Book bookToBeReturned = new Book("The Hobbit");
        MainMenu.RETURN_BOOK.act(library, inputDriver, outputDriver);
        verify(library).returnBook(bookToBeReturned);
    }
}
