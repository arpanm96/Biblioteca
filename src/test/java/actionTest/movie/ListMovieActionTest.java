package actionTest.movie;

import controller.MainMenu;
import model.library.ItemType;
import model.library.Library;
import model.library.Movie;
import model.user.User;
import model.user.UserAccount;
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

    UserAccount userAccount;
    Collection<Movie> movieDetails;
    Collection<String> bookDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        userAccount = new UserAccount();;
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        bookDetails = library.getLibraryItemDetails(ItemType.BOOK);
    }


    @DisplayName("verify list movies")
    @Test
    void shouldListMovies() {
        MainMenu.LIST_BOOKS.perform(library, inputDriver, outputDriver, userAccount);
        verify(outputDriver).printBookList(bookDetails);
        verify(library,times(2)).getLibraryItemDetails(ItemType.BOOK);
    }
}
