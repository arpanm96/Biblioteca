package action.movie;

import controller.Action;
import model.library.ItemType;
import model.library.Library;
import view.InputDriver;
import view.OutputDriver;

public class ListMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.printMovieList(library.getLibraryItemDetails(ItemType.MOVIE));
    }
}
