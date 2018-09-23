package actionTest.book;

import common.Message;
import controller.Action;
import model.library.Book;
import model.library.Library;
import view.InputDriver;
import view.OutputDriver;

public class ReturnBookAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Book bookToBeReturned = new Book(inputDriver.getUserInput());
        if (library.returnItem(bookToBeReturned)) {
            outputDriver.print(Message.SUCCESSFUL_BOOK_RETURN);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_BOOK_RETURN);
        }
    }
}
