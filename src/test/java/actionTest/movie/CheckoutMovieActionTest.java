package actionTest.movie;

import common.Message;
import controller.MainMenu;
import model.library.ItemType;
import model.library.Library;
import model.library.LibraryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutMovieActionTest {

    Collection<String> movieDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void initEach() {
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        movieDetails = library.getLibraryItemDetails(ItemType.MOVIE);
    }

    @DisplayName("verify movie is not checked out")
    @Test
    void shouldNotCheckoutMovie() {
        when(inputDriver.getUserInput()).thenReturn("A Random Movie");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.UNSUCCESSFUL_MOVIE_CHECKOUT);
    }

    @DisplayName("verify movie is checked out")
    @Test
    void shouldCheckoutMovie() {
        when(inputDriver.getUserInput()).thenReturn("Shawshank Redemption");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_CHECKOUT);
    }
}