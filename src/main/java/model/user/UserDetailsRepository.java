package model.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
A class containing the registered users list for the library
*/

public class UserDetailsRepository {
    Collection<User> userList;

    public UserDetailsRepository() {
        this.userList = generateDefaultUserList();
    }

    public Collection<User> generateDefaultUserList() {
        return new ArrayList<>(Arrays.asList(new User("234-5678", "Arpan"),
                new User("123-4567", "Arpan")));
    }
}
