package model.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class UserAccount {
    private Collection<User> userCollection;
    //private isLoggedIn

    public UserAccount() {
        userCollection = new ArrayList<>(Arrays.asList(new User("123-4567", "Arpan")));
    }

    public boolean logIn(User user) {
        if(!userCollection.contains(user)) {
            return false;
        }
        return true;
    }
}
