package action.movie;

import common.Message;
import controller.Action;
import model.library.Movie;
import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class CheckOutMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        Movie movieToBeCheckedOut = new Movie(inputDriver.getUserInput());
        if (library.checkoutItem(movieToBeCheckedOut)) {
            outputDriver.print(Message.SUCCESSFUL_MOVIE_CHECKOUT);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_MOVIE_CHECKOUT);
        }
    }
}
