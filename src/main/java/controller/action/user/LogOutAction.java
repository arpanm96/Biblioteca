package controller.action.user;

import common.Message;
import controller.Action;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to enable the currently logged in user to log out
*/

public class LogOutAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        if(userAction.logOut()) {
            outputDriver.print(Message.LOG_OUT_SUCCESSFUL);
        }
        else {
            outputDriver.print(Message.LOG_OUT_UNSUCCESSFUL);
        }
    }
}
