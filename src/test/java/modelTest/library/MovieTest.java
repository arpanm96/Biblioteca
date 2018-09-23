package modelTest.library;

import model.library.ItemType;
import model.library.Library;
import model.library.LibraryItemRepository;
import model.library.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MovieTest {

    Movie shawshankRedemption;
    Movie se7en;
    Collection<String> movieDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        shawshankRedemption = new Movie("Shawshank Redemption", "Frank Darabont", 10, 1994);
        se7en = new Movie("Se7en", "David Fincher", 9, 1995);

        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        movieDetails = library.getLibraryItemDetails(ItemType.MOVIE);
    }

    @DisplayName("print the shawshank movie")
    @Test
    void shouldPrintShawshankRedemptionMovie() {
        assertEquals("Shawshank Redemption,Frank Darabont,10,1994",shawshankRedemption.toString());
    }

    @DisplayName("print the se7en movie")
    @Test
    void shouldPrintSe7enMovie() {
        assertEquals("Se7en,David Fincher,9,1995",se7en.toString());
    }
}
