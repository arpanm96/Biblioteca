package view;

import common.*;

import model.Library;

/*
A class to perform all the output functions
*/

public class OutputDriver {
    public void printWelcomeMessage() {
        System.out.println(Message.WELCOME);
    }

    public void printBookList(Library library) {
        System.out.println(library);
    }
}
