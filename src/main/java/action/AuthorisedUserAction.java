package action;

import common.Message;
import controller.Action;
import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class AuthorisedUserAction implements Action {
    private Action action;

    public AuthorisedUserAction(Action action) {
        this.action = action;
    }

    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        if(userAccount.isUserLoggedIn()) {
            action.act(library,inputDriver,outputDriver, userAccount);
        }
        else {
            outputDriver.print(Message.PLEASE_LOG_IN);
        }
    }
}
