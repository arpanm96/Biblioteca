package model;

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

    public boolean checkoutItem(Item bookToBeCheckedOut) {
        for (Item book : itemList) {
            if (book.equals(bookToBeCheckedOut)) {
                itemToBeReturnedList.add(book);
                itemList.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnItem(Item returnItem) {
        if (itemToBeReturnedList != null && this.containsItem(returnItem)) {
            itemList.add(returnItem);
            itemToBeReturnedList.remove(returnItem);
            return true;
        }
        return false;
    }

    private boolean containsItem(Item returnItem) {
        for (Item book : itemToBeReturnedList) {
            if (book.equals(returnItem)) {
                return true;
            }
        }
        return false;
    }
}
