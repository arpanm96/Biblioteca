package model.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class UserAccount {
    private Collection<User> userCollection;
    private Collection<User> loggedInUser;

    public UserAccount() {
        loggedInUser = new ArrayList<>();
        userCollection = new ArrayList<>(Arrays.asList(new User("123-4567", "Arpan")));
    }

    public boolean logIn(User user) {
        if(!userCollection.contains(user)) {
            return false;
        }
        loggedInUser.add(user);
        return true;
    }

    public boolean isUserLoggedIn() {
        return !loggedInUser.isEmpty();
    }
}
