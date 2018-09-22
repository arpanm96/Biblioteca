package action.movie;

import common.Message;
import controller.Action;
import model.Movie;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class CheckOutMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Movie movieToBeCheckedOut = new Movie(inputDriver.getUserInput());
        if (library.checkoutItem(movieToBeCheckedOut)) {
            outputDriver.print(Message.SUCCESSFUL_MOVIE_CHECKOUT);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_MOVIE_CHECKOUT);
        }
    }
}
