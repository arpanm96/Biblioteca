package view;

import common.*;
import controller.MainMenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

/*
A class to perform all the output functions
*/

public class OutputDriver {
    public void printWelcomeMessage() {
        System.out.println(Message.WELCOME);
    }

    public void printBookList(Collection<String> bookDetails) {
        ArrayList<String> books = new ArrayList<>(bookDetails);
        books.add(0, "Title,Author,Year Published");
        Collection<String> bookDetailsFormattedColomns = new ViewFormatter().formatAccordingToColomns(books);
        for (String book : bookDetailsFormattedColomns) {
            System.out.println(book);
        }
    }

    private void printMenuSeparator() {
        Stream.generate(() -> Message.MENU_SEPERATOR).limit(80).forEach(System.out::print);
        System.out.println();
    }

    public void printMainMenu() {
        printMenuSeparator();
        int i = 1;
        for (MainMenu menu : MainMenu.values()) {
            System.out.println(i++ + "  " + menu);
        }
        printMenuSeparator();
    }

    public void printInvalidMenuChoice() {
        System.out.println(Message.INVALID_INPUT);
    }

    public void printBookCheckedOut() {
        System.out.println(Message.SUCCESSFUL_CHECKOUT);
    }

    public void printBookNotCheckedOut() {
        System.out.println(Message.UNSUCCESSFUL_CHECKOUT);
    }

    public void printBookReturned() {
        System.out.println(Message.SUCCESSFUL_RETURN);
    }

    public void printBookNotReturned() {
        System.out.println(Message.UNSUCCESSFUL_RETURN);
    }
}
