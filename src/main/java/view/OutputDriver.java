package view;

import common.*;
import controller.MainMenu;

import java.util.Collection;

/*
A class to perform all the output functions
*/

public class OutputDriver {
    public void printWelcomeMessage() {
        System.out.println(Message.WELCOME);
    }

    public void printBookList(Collection<String> bookDetails) {
        for (String book : bookDetails) {
            System.out.println(book);
        }
    }

    public void printMainMenu() {
        int i = 1;
        for (MainMenu menu : MainMenu.values()) {
            System.out.println(i++ + "  " + menu);
        }
    }

    public void printInvalidMenuChoice() {
        System.out.println(Message.INVALID_INPUT);
    }
}
