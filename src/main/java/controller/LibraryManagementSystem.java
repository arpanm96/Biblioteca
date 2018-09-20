package controller;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

/*
A class to drive together the whole library management system
*/

public class LibraryManagementSystem {
    private InputDriver inputDriver;
    private OutputDriver outputDriver;
    private Library library;

    public LibraryManagementSystem() {
        this.inputDriver = new InputDriver();
        this.outputDriver = new OutputDriver();
        library = new Library();
    }

    public void displayMenu() {
        outputDriver.printMainMenu();
        int choice = inputDriver.getMenuChoiceFromUser();
        displayMenuChoice(choice);
    }


    public void displayMenuChoice(int choice) {
        MainMenu.values()[choice-1].displayMenu(library);
    }

    public void displayInitial() {
        outputDriver.printWelcomeMessage();
        List<String> list = new ArrayList<>(library.getLibraryBookDetails());
        outputDriver.printBookList(list);
    }
}
