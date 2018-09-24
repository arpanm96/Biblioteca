package model.library;

import model.user.UserAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/*
A class for a library containing books
*/

public class Library {
    private Collection<Item> itemList;
    private Collection<Item> itemToBeReturnedList;

    public Library(Collection<Item> itemList) {
        itemToBeReturnedList = new ArrayList<>();
        this.itemList = itemList;
    }

    public Collection<String> getLibraryItemDetails(ItemType itemType) {
        return this.itemList.stream().
                filter((item -> item.getItemType().equals(itemType))).
                map(book -> (book.toString())).
                collect(Collectors.toList());
    }

    public boolean checkoutItem(Item itemToBeCheckedOut, UserAction userAction) {
        for (Item item : itemList) {
            if (item.equals(itemToBeCheckedOut)) {
                userAction.getCurrentlyLoggedInUser().updateUserCheckoutItemList(item, CheckoutType.CHECKOUT);
                itemToBeReturnedList.add(item);
                itemList.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean returnItem(Item returnItem, UserAction userAction) {
        if (itemToBeReturnedList != null && this.containsItem(returnItem)) {
            userAction.getCurrentlyLoggedInUser().updateUserCheckoutItemList(returnItem, CheckoutType.RETURN);
            itemToBeReturnedList.remove(returnItem);
            return true;
        }
        return false;
    }

    private boolean containsItem(Item returnItem) {
        for (Item item : itemToBeReturnedList) {
            if (item.equals(returnItem)) {
                itemList.add(item);
                return true;
            }
        }
        return false;
    }
}
