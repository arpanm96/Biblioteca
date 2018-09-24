package controller.action;

import controller.Action;
import model.library.Item;
import model.library.ItemType;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
A class to perform to the listing of all the currently checked out items of the user
*/

public class ListCheckedOutItemsAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        Collection<Item> checkedOutItemsList = userAction.getCurrentlyLoggedInUser().getCurrentCheckedOutItems();

        List<String> bookDetails = checkedOutItemsList.stream().
                filter(item -> item.getItemType().equals(ItemType.BOOK)).
                map(item -> (item.toString())).
                collect(Collectors.toList());

        List<String> movieDetails = checkedOutItemsList.stream().
                filter(item -> item.getItemType().equals(ItemType.MOVIE)).
                map(item -> (item.toString())).
                collect(Collectors.toList());

        if (!bookDetails.isEmpty()) {
            outputDriver.printItemList(bookDetails, ItemType.BOOK.getItemHeaders());
        }

        if (!movieDetails.isEmpty()) {
            outputDriver.printItemList(movieDetails, ItemType.MOVIE.getItemHeaders());
        }
    }
}
