package model.user;

import java.util.ArrayList;
import java.util.Collection;

public class UserAccount {
    private Collection<User> userCollection;
    private Collection<User> loggedInUser;

    public UserAccount(Collection<User> userCollection) {
        loggedInUser = new ArrayList<>();
        this.userCollection = userCollection;
    }

    public boolean logIn(User user) {
        if (!userCollection.contains(user) || loggedInUser.contains(user)) {
            return false;
        }
        loggedInUser.add(user);
        return true;
    }

    public boolean logOut() {
        if (isUserLoggedIn()) {
            loggedInUser.clear();
            return true;
        }
        return false;
    }

    public boolean isUserLoggedIn() {
        return !loggedInUser.isEmpty();
    }

    public User getCurrentlyLoggedInUser() {
        return (User) (loggedInUser.toArray()[0]);
    }
}
