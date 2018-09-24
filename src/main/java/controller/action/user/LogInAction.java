package controller.action.user;

import common.Message;
import controller.Action;
import model.library.Library;
import model.user.User;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to enable user log in
*/

public class LogInAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        User user = new User(inputDriver.getUserInput(), inputDriver.getUserInput());
        if(userAction.logIn(user)) {
            outputDriver.print(Message.LOG_IN_SUCCESSFUL);
        }
        else {
            outputDriver.print(Message.LOG_IN_UNSUCCESSFUL);
        }
    }
}
