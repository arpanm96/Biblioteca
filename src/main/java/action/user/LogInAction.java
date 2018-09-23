package action.user;

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
            System.out.println(Message.LOG_IN_USER_FOUND);
        }
        else {
            System.out.println(Message.LOG_IN_USER_NOT_FOUND);
        }
    }
}
