package controllerTest;

import controller.MainMenu;
import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccessTypeTest {

    UserAction userAction;
    User user;

    @BeforeEach
    void initEach() {
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
        user = new User("123-4567", "Arpan", "a@gmail.com", 12345);

    }

    @DisplayName("should always return true for access type of ALWAYS menus i.e user is not logged in")
    @Test
    void shouldReturnTrueForTheMenusWhenUserIsNotLoggedIn() {
        assertAll(() -> {
            assertTrue(MainMenu.LIST_BOOKS.isValidMenu(userAction));
            assertTrue(MainMenu.LIST_MOVIES.isValidMenu(userAction));
            assertTrue(MainMenu.LOG_IN.isValidMenu(userAction));
            assertTrue(MainMenu.QUIT.isValidMenu(userAction));
            assertFalse(MainMenu.CHECKOUT_BOOK.isValidMenu(userAction));
            assertFalse(MainMenu.CHECKOUT_MOVIE.isValidMenu(userAction));
            assertFalse(MainMenu.RETURN_BOOK.isValidMenu(userAction));
            assertFalse(MainMenu.RETURN_MOVIE.isValidMenu(userAction));
            assertFalse(MainMenu.LOG_OUT.isValidMenu(userAction));
            assertFalse(MainMenu.CHECKOUT_BOOK.isValidMenu(userAction));
        });
    }

    @DisplayName("should always return true for access type of menus when user is logged in")
    @Test
    void shouldReturnTrueForTheMenusWhenUserIsLoggedIn() {
        userAction.logIn(user);
        assertAll(() -> {
            assertTrue(MainMenu.LIST_BOOKS.isValidMenu(userAction));
            assertTrue(MainMenu.LIST_MOVIES.isValidMenu(userAction));
            assertFalse(MainMenu.LOG_IN.isValidMenu(userAction));
            assertTrue(MainMenu.QUIT.isValidMenu(userAction));
            assertTrue(MainMenu.CHECKOUT_BOOK.isValidMenu(userAction));
            assertTrue(MainMenu.CHECKOUT_MOVIE.isValidMenu(userAction));
            assertTrue(MainMenu.RETURN_BOOK.isValidMenu(userAction));
            assertTrue(MainMenu.RETURN_MOVIE.isValidMenu(userAction));
            assertTrue(MainMenu.LOG_OUT.isValidMenu(userAction));
            assertTrue(MainMenu.CHECKOUT_BOOK.isValidMenu(userAction));
        });
    }
}
