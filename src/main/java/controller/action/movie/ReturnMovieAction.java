package controller.action.movie;

import common.Message;
import controller.Action;
import model.library.Library;
import model.library.Movie;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class ReturnMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        Movie bookToBeReturned = new Movie(inputDriver.getUserInput());
        if (library.returnItem(bookToBeReturned)) {
            outputDriver.print(Message.SUCCESSFUL_MOVIE_RETURN);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_MOVIE_RETURN);
        }
    }
}
