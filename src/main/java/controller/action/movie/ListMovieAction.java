package controller.action.movie;

import controller.Action;
import model.library.ItemType;
import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class ListMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        outputDriver.printMovieList(library.getLibraryItemDetails(ItemType.MOVIE));
    }
}
