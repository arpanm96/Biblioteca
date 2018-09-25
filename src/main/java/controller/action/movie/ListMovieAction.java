package controller.action.movie;

import controller.Action;
import model.library.ItemType;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to perform the listing of all the movies in the library
*/

public class ListMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        outputDriver.printList(library.getLibraryItemDetails(ItemType.MOVIE), ItemType.MOVIE.getItemHeaders());
    }
}
