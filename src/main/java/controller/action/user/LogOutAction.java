package controller.action.user;

import common.Message;
import controller.Action;
import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class LogOutAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        if(userAccount.logOut()) {
            outputDriver.print(Message.LOG_OUT_SUCCESSFUL);
        }
        else {
            outputDriver.print(Message.LOG_OUT_UNSUCCESSFUL);
        }
    }
}
