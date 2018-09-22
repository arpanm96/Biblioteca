package controller;

import model.Book;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckOutBookAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Book bookToBeCheckedOut = new Book(inputDriver.getBookToBeCheckedOut());
        if (library.checkoutBook(bookToBeCheckedOut)) {
            outputDriver.printBookCheckedOut();
        } else {
            outputDriver.printBookNotCheckedOut();
        }
    }
}

