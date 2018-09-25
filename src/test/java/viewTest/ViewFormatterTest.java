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

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ViewFormatterTest {

    Collection<String> bookDetails;

    Library library;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = new Library( new LibraryItemRepository().generateDefaultItemList());
        outputDriver = new OutputDriver();
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
    }

    @DisplayName("should return correct formatted string for book The Hobbit")
    @Test
    void shouldReturnTheBookDetailInFormattedManner() {
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
        ViewFormatter viewFormatter = new ViewFormatter();
        assertEquals(new ArrayList<>(Arrays.asList("The Hobbit            " +
                "        Tolkien                       1937                          ","The Lord Of The Rings" +
                        "         Tolkien                       1954                          "))
                ,viewFormatter.formatAccordingToColomns(library.getLibraryItemDetails(ItemType.BOOK)));
    }
}
