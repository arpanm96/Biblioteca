package action.movie;

import common.Message;
import controller.Action;
import model.library.Library;
import model.library.Movie;
import view.InputDriver;
import view.OutputDriver;

public class ReturnMovieAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        Movie bookToBeReturned = new Movie(inputDriver.getUserInput());
        if (library.returnItem(bookToBeReturned)) {
            outputDriver.print(Message.SUCCESSFUL_MOVIE_RETURN);
        } else {
            outputDriver.print(Message.UNSUCCESSFUL_MOVIE_RETURN);
        }
    }
}
