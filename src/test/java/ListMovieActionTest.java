import controller.MainMenu;
import model.ItemType;
import model.Library;
import model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ListMovieActionTest {

    Collection<Movie> movieDetails;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
    }


    @DisplayName("list movies")
    @Test
    void shouldListMovies() {
        MainMenu.LIST_BOOKS.perform(library, inputDriver, outputDriver);
        verify(outputDriver).printBookList(bookDetails);
        verify(library,times(2)).getLibraryItemDetails(ItemType.BOOK);
    }
}
