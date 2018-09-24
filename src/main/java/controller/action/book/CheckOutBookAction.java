package controller.action.book;

import common.Message;
import controller.Action;
import model.library.Book;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to perform the checkout of books
*/

public class CheckOutBookAction implements Action {

    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        Book bookToBeCheckedOut = new Book(inputDriver.getUserInput());
        if (library.checkoutItem(bookToBeCheckedOut, userAction)) {
            outputDriver.print(Message.SUCCESSFUL_BOOK_CHECKOUT);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_BOOK_CHECKOUT);
        }
    }
}

