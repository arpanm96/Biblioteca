package modelTest.user;

import model.user.User;
import model.user.UserAccount;
import model.user.UserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserAccountTest {

    User unknownUser = new User("000-0000","Unknown");
    User knownUser = new User("123-4567", "Arpan");
    UserAccount userAccount;
    @BeforeEach
    void initEach() {
        userAccount = new UserAccount(new UserDetailsRepository().generateDefaultUserList());
    }

    @DisplayName("should not allow login to unknown users")
    @Test
    void shouldNotAllowUnknownUserLogIn() {
        assertFalse(userAccount.logIn(unknownUser));
    }

    @DisplayName("should allow login to known users")
    @Test
    void shouldAllowKnownUserToLogIn() {
        assertTrue(userAccount.logIn(knownUser));
    }

    @DisplayName("should return true if known user is logged in")
    @Test
    void shouldReturnTrueIfUserIsLoggedIn() {
        assertTrue(userAccount.logIn(knownUser));
    }

    @DisplayName("should allow user to log out if they are already logged in")
    @Test
    void shouldReturnTrueIfUserIsLoggedOut() {
        assertTrue(userAccount.logIn(knownUser));
        assertTrue(userAccount.logOut());
    }

    @DisplayName("shouldn't allow user to log out if they are not already logged in")
    @Test
    void shouldReturnFalseIfUserIsLoggedOut() {
        assertFalse(userAccount.logOut());
    }
}
