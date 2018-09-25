package controller.action.book;

import controller.Action;
import model.library.ItemType;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to perform the listing of all the books in the library
*/

public class ListBookAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        outputDriver.printList(library.getLibraryItemDetails(ItemType.BOOK), ItemType.BOOK.getItemHeaders());
    }
}
