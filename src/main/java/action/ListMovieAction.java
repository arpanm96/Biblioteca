package action;

import controller.Action;
import model.ItemType;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ListMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.printMovieList(library.getLibraryItemDetails(ItemType.MOVIE));
    }
}
