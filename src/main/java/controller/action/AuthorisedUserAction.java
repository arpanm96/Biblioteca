package controller.action;

import common.Message;
import controller.Action;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to authorise actions only if the user has logged in
*/

public class AuthorisedUserAction implements Action {
    private Action action;

    public AuthorisedUserAction(Action action) {
        this.action = action;
    }

    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        if (userAction.isUserLoggedIn()) {
            action.act(library, inputDriver, outputDriver, userAction);
        } else {
            outputDriver.print(Message.PLEASE_LOG_IN);
        }
    }
}
