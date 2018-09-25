package controller.action.user;

import controller.Action;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

public class UserInformationAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        outputDriver.printUser(userAction.getCurrentlyLoggedInUser().toString());
    }
}
