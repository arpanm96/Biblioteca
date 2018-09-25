package model.user;

import java.util.ArrayList;
import java.util.Collection;

/*
A class to manage user actions
*/

public class UserAction {
    private Collection<User> userCollection;
    private Collection<User> loggedInUser;

    public UserAction(Collection<User> userCollection) {
        loggedInUser = new ArrayList<>();
        this.userCollection = userCollection;
    }

    public boolean logIn(User user) {
        if (!userCollection.contains(user) || loggedInUser.contains(user)) {
            return false;
        }
        loggedInUser.add(getUser(user));
        return true;
    }

    private User getUser(User inputUser) {
        return userCollection.stream().filter((user)-> user.equals(inputUser)).
        findFirst().get();
    }

    public boolean logOut() {
        if (isUserLoggedIn()) {
            loggedInUser.remove(getCurrentlyLoggedInUser());
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
