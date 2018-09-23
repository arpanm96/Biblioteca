package model.library;

import model.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/*
A class for a library containing books
*/

public class Library {
    private Collection<Item> itemList;
    private Collection<Item> itemToBeReturnedList;
    private Map<Item, User> itemToBeReturnedByUser;
    private User loggedInUser;

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

    public boolean checkoutItem(Item itemToBeCheckedOut) {
        for (Item item : itemList) {
            if (item.equals(itemToBeCheckedOut)) {
                itemToBeReturnedList.add(item);
                itemList.remove(item);
                return true;
            }
        }
        return false;
    }

/*    public boolean checkoutItemByUser(Item itemToBeCheckedOut,User user) {
        for (Map m: Map.Entry<String,String>) {
            if (item.equals(itemToBeCheckedOut)) {
                itemToBeReturnedList.add(item);
                itemList.remove(item);
                return true;
            }
        }
        return false;
    }*/


    public boolean returnItem(Item returnItem) {
        if (itemToBeReturnedList != null && this.containsItem(returnItem)) {
            itemList.add(returnItem);
            itemToBeReturnedList.remove(returnItem);
            return true;
        }
        return false;
    }

    private boolean containsItem(Item returnItem) {
        for (Item item : itemToBeReturnedList) {
            if (item.equals(returnItem)) {
                return true;
            }
        }
        return false;
    }
}
