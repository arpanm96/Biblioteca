package actionTest.movie;

import common.Message;
import controller.MainMenu;
import model.library.ItemType;
import model.library.Library;
import model.library.LibraryItemRepository;
import model.user.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnMovieActionTest {
    UserAccount userAccount;
    Collection<String> movieDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        movieDetails = library.getLibraryItemDetails(ItemType.BOOK);
        userAccount = new UserAccount();;
    }

    @DisplayName("should not return back an already present movie")
    @Test
    void shouldNotReturnMovie() {
        when(inputDriver.getUserInput()).thenReturn("Se7en");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAccount);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_CHECKOUT);

        when(inputDriver.getUserInput()).thenReturn("Shawshank Redemption");
        MainMenu.RETURN_MOVIE.perform(library, inputDriver, outputDriver, userAccount);
        verify(outputDriver).print(Message.UNSUCCESSFUL_MOVIE_RETURN);
    }

    @DisplayName("should return back a checked out movie")
    @Test
    void shouldReturnMovie() {
        when(inputDriver.getUserInput()).thenReturn("Se7en");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAccount);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_CHECKOUT);


        when(inputDriver.getUserInput()).thenReturn("Se7en");
        MainMenu.RETURN_MOVIE.perform(library, inputDriver, outputDriver, userAccount);
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_RETURN);
    }
}
