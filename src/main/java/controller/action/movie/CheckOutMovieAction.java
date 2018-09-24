package controller.action.movie;

import common.Message;
import controller.Action;
import model.library.Movie;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to perform the checkout of movies
*/

public class CheckOutMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        Movie movieToBeCheckedOut = new Movie(inputDriver.getUserInput());
        if (library.checkoutItem(movieToBeCheckedOut, userAction)) {
            outputDriver.print(Message.SUCCESSFUL_MOVIE_CHECKOUT);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_MOVIE_CHECKOUT);
        }
    }
}
