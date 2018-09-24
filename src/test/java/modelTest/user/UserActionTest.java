package modelTest.user;

import model.user.User;
import model.user.UserAction;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserActionTest {

    User unknownUser = new User("000-0000","Unknown");
    User knownUser = new User("123-4567", "Arpan");
    UserAction userAction;
    @BeforeEach
    void initEach() {
        userAction = new UserAction(new UserDetailsRepository().generateDefaultUserList());
    }

    @DisplayName("should not allow login to unknown users")
    @Test
    void shouldNotAllowUnknownUserLogIn() {
        assertFalse(userAction.logIn(unknownUser));
    }

    @DisplayName("should allow login to known users")
    @Test
    void shouldAllowKnownUserToLogIn() {
        assertTrue(userAction.logIn(knownUser));
    }

    @DisplayName("should return true if known user is logged in")
    @Test
    void shouldReturnTrueIfUserIsLoggedIn() {
        assertTrue(userAction.logIn(knownUser));
    }

    @DisplayName("should allow user to log out if they are already logged in")
    @Test
    void shouldReturnTrueIfUserIsLoggedOut() {
        assertTrue(userAction.logIn(knownUser));
        assertTrue(userAction.logOut());
    }

    @DisplayName("shouldn't allow user to log out if they are not already logged in")
    @Test
    void shouldReturnFalseIfUserIsLoggedOut() {
        assertFalse(userAction.logOut());
    }
}
