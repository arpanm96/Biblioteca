package action.user;

import controller.Action;
import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public class LogOutAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        userAccount.logOut();
    }
}
