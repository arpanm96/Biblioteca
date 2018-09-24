package model.user;

import model.library.CheckoutType;
import model.library.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/*
A class containing the user details and perform user operations
*/

public class User {
    private String id;
    private String password;
    private Collection<Item> checkoutItemCollection;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        checkoutItemCollection = new ArrayList<>();
    }

    public void updateUserCheckoutItemList(Item item, CheckoutType checkoutType) {
        checkoutType.updateUserItemCheckoutList(checkoutItemCollection, item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }

    public Collection<Item> getCurrentCheckedOutItems() {
        return checkoutItemCollection;
    }
}
