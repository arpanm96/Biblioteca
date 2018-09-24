package controller.action.movie;

import common.Message;
import controller.Action;
import model.library.Library;
import model.library.Movie;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to perform the listing of all the movies in the library
*/

public class ReturnMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        Movie bookToBeReturned = new Movie(inputDriver.getUserInput());
        if (library.returnItem(bookToBeReturned, userAction)) {
            outputDriver.print(Message.SUCCESSFUL_MOVIE_RETURN);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_MOVIE_RETURN);
        }
    }
}
