
import model.Book;
import model.ItemType;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }
}
