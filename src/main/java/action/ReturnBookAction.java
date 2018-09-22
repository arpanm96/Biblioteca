package action;

import controller.Action;
import model.Book;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ReturnBookAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Book bookToBeReturned =  new Book(inputDriver.getBookToBeReturned());
        if(library.returnItem(bookToBeReturned)){
            outputDriver.printBookReturned();
        }
        else {
            outputDriver.printBookNotReturned();
        }
    }
}
