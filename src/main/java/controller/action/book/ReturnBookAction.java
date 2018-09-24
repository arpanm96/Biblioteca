package controller.action.book;

import common.Message;
import controller.Action;
import model.library.Book;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to perform the returning of a book after it has been checked out
*/

public class ReturnBookAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        Book bookToBeReturned = new Book(inputDriver.getUserInput());
        if (library.returnItem(bookToBeReturned, userAction)) {
            outputDriver.print(Message.SUCCESSFUL_BOOK_RETURN);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_BOOK_RETURN);
        }
    }
}
