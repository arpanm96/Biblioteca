package controller;

import common.Message;
import model.library.Library;
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
A class to drive together the whole library management system
*/

public class LibraryManagementSystem {
    public static final int INDEX_OFFSET = 1;
    private InputDriver inputDriver;
    private OutputDriver outputDriver;
    private Library library;
    private UserAction userAction;

    public LibraryManagementSystem(InputDriver inputDriver, OutputDriver outputDriver, Library library, UserAction userAction) {
        this.inputDriver = inputDriver;
        this.outputDriver = outputDriver;
        this.library = library;
        this.userAction = userAction;
    }

    private boolean isValidInput(int choice) {
        return choice <= MainMenu.values().length && choice >= INDEX_OFFSET;
    }

    private void performOnMainMenu(int choice) {
        MainMenu.values()[choice - 1].perform(library, inputDriver, outputDriver, userAction);
    }

    public void start() {
        outputDriver.printWelcomeMessage();
    }

    public void operateMainMenu() throws ArrayIndexOutOfBoundsException {
        int choice = 0;
        do {
            outputDriver.printMainMenu();
            choice = inputDriver.getMenuChoiceFromUser();
            if (isValidInput(choice)) {
                performOnMainMenu(choice);
            } else {
                outputDriver.print(Message.INVALID_INPUT);
                choice = INDEX_OFFSET;
            }
        } while (!MainMenu.values()[choice - 1].equals(MainMenu.QUIT));
    }

}
