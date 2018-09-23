package actionTest.movie;

import common.Message;
import controller.MainMenu;
import model.library.ItemType;
import model.library.Library;
import model.library.LibraryItemRepository;
import model.user.User;
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

public class CheckoutMovieActionTest {

    UserAccount userAccount;
    Collection<String> movieDetails;

    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    User user;

    @BeforeEach
    void initEach() {
        user = new User("123-4567", "Arpan");
        library = new Library(new LibraryItemRepository().generateDefaultItemList());
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        userAccount = new UserAccount();;
        movieDetails = library.getLibraryItemDetails(ItemType.MOVIE);
    }

    @DisplayName("verify movie is not checked out")
    @Test
    void shouldNotCheckoutMovie() {
        userAccount.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("A Random Movie");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAccount);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.UNSUCCESSFUL_MOVIE_CHECKOUT);
    }

    @DisplayName("verify movie is checked out")
    @Test
    void shouldCheckoutMovie() {
        userAccount.logIn(user);
        when(inputDriver.getUserInput()).thenReturn("Shawshank Redemption");
        MainMenu.CHECKOUT_MOVIE.perform(library, inputDriver, outputDriver, userAccount);
        verify(inputDriver).getUserInput();
        verify(outputDriver).print(Message.SUCCESSFUL_MOVIE_CHECKOUT);
    }
}
