package controller.action;

import common.Message;
import controller.Action;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to quit the biblioteca application
*/

public class QuitAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        outputDriver.print(Message.EXIT_BIBLIOTECA);
    }
}
