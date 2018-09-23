package action.book;

import common.Message;
import controller.Action;
import model.library.Book;
import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class CheckOutBookAction implements Action {

    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        Book bookToBeCheckedOut = new Book(inputDriver.getUserInput());
        if (library.checkoutItem(bookToBeCheckedOut)) {
            outputDriver.print(Message.SUCCESSFUL_BOOK_CHECKOUT);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_BOOK_CHECKOUT);
        }
    }
}

