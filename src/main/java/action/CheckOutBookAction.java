package action;

import controller.Action;
import model.Book;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckOutBookAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Book bookToBeCheckedOut = new Book(inputDriver.getBookToBeCheckedOut());
        if (library.checkoutItem(bookToBeCheckedOut)) {
            outputDriver.printBookCheckedOut();
        } else {
            outputDriver.printBookNotCheckedOut();
        }
    }
}

