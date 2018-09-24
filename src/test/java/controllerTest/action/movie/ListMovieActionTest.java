package controllerTest.action.movie;

import controller.MainMenu;
import model.library.ItemType;
import model.library.Library;
import model.library.Movie;
import model.user.UserAction;
import model.user.UserDetailsRepository;
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

    UserAction userAction;
    Collection<Movie> movieDetails;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());;
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
    }


    @DisplayName("verify list movies")
    @Test
    void shouldListMovies() {
        MainMenu.LIST_BOOKS.perform(library, inputDriver, outputDriver, userAction);
        verify(outputDriver).printItemList(bookDetails,ItemType.BOOK.getItemHeaders());
        verify(library,times(2)).getLibraryItemDetails(ItemType.BOOK);
    }
}
