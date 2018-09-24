package controller;

import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
An interface to provide the basic functionality of the menu choice chosen by the user
*/

public interface Action {
    void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction);
}
