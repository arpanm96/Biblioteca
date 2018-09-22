package view;

import common.*;
import controller.MainMenu;
import model.ItemType;

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

    public void printBookList(Collection<String> itemDetails) {
        ArrayList<String> items = new ArrayList<>(itemDetails);
        items.add(0, ItemType.BOOK.getItemHeaders());
        printFormattedList(items);
    }

    public void printMovieList(Collection<String> itemDetails) {
        ArrayList<String> items = new ArrayList<>(itemDetails);
        items.add(0, ItemType.MOVIE.getItemHeaders());
        printFormattedList(items);
    }

    private void printFormattedList(ArrayList<String> items) {
        Collection<String> bookDetailsFormattedColomns = new ViewFormatter().formatAccordingToColomns(items);
        for (String item : bookDetailsFormattedColomns) {
            System.out.println(item);
        }
    }

    private void printMenuSeparator() {
        Stream.generate(() -> Message.MENU_SEPERATOR).limit(120).forEach(System.out::print);
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

    public void print(String message) {
        System.out.println(message);
    }
}
