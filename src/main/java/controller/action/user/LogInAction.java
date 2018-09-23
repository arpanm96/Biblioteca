package controller.action.user;

import common.Message;
import controller.Action;
import model.library.Library;
import model.user.User;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class LogInAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        User user = new User(inputDriver.getUserInput(), inputDriver.getUserInput());
        if(userAccount.logIn(user)) {
            outputDriver.print(Message.LOG_IN_SUCCESSFUL);
        }
        else {
            outputDriver.print(Message.LOG_IN_UNSUCCESSFUL);
        }
    }
}
