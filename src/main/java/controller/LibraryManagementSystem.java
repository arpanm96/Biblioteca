package controller;

import common.Message;
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
        int choice = 0;
        while ((choice = inputDriver.getMenuChoiceFromUser()) != 1) {
            if(isValidInput(choice)){
                displayMenuChoice(choice);
            }
            else {
                System.out.println(Message.INVALID_INPUT);
            }
        }
    }

    public boolean isValidInput(int choice) {
        return choice <= MainMenu.values().length && choice >= 1;
    }


    public void displayMenuChoice(int choice) {
        MainMenu.values()[choice-1].act(library);
    }

    public void displayInitial() {
        outputDriver.printWelcomeMessage();
        List<String> list = new ArrayList<>(library.getLibraryBookDetails());
        outputDriver.printBookList(list);
    }
}
