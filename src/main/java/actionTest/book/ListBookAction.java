package actionTest.book;

import controller.Action;
import model.library.ItemType;
import model.library.Library;
import view.InputDriver;
import view.OutputDriver;

public class ListBookAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.printBookList(library.getLibraryItemDetails(ItemType.BOOK));
    }
}
