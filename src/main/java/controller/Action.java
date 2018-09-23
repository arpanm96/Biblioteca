package controller;

import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public interface Action {
    void act(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount);
}
