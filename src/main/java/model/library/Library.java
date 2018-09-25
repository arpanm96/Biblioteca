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

    public boolean returnItem(Item item, UserAction userAction) {
        Item returnItem = containsItem(item);
        if (itemToBeReturnedList != null && returnItem != null &&
                userAction.getCurrentlyLoggedInUser().getCurrentCheckedOutItems().contains(item)) {
            userAction.getCurrentlyLoggedInUser().updateUserCheckoutItemList(item, CheckoutType.RETURN);
            itemList.add(returnItem);
            itemToBeReturnedList.remove(returnItem);
            return true;
        }
        return false;
    }

    private Item containsItem(Item returnItem) {
        for (Item item : itemToBeReturnedList) {
            if (item.equals(returnItem)) {
                return item;
            }
        }
        return null;
    }
}
