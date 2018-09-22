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

    Collection<Movie> movieCollection;
    Collection<String> movieDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        movieDetails = library.getLibraryItemDetails(ItemType.MOVIE);
    }


    @DisplayName("list movies")
    @Test
    void shouldListMovies() {
        MainMenu.LIST_MOVIES.perform(library, inputDriver, outputDriver);
        verify(outputDriver).printBookList(movieDetails);
        verify(library,times(2)).getLibraryItemDetails(ItemType.MOVIE);
    }
}
