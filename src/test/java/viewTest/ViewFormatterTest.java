package viewTest;

import model.library.Book;
import model.library.LibraryItemRepository;
import model.library.ItemType;
import model.library.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputDriver;
import view.ViewFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class ViewFormatterTest {

    Book theHobbit;
    Book theLordOfTheRings;
    Collection<String> bookDetails;

    Library library;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = new Library( new LibraryItemRepository().generateDefaultItemList());
        outputDriver = new OutputDriver();
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("should return correct formatted string for book The Hobbit")
    @Test
    void shouldReturnFormattedTheHobbit() {
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        ViewFormatter viewFormatter = new ViewFormatter();
        String firstRow = "Title,Author,Year Published";
        outputDriver.printBookList(viewFormatter.formatAccordingToColomns(new ArrayList<>(Arrays.asList(firstRow))));
        outputDriver.printBookList(viewFormatter.formatAccordingToColomns(bookDetails));
    }
}
