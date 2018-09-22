package controller;

import model.BookRepository;
import model.Library;
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

    public LibraryManagementSystem(InputDriver inputDriver, OutputDriver outputDriver, Library library) {
        this.inputDriver = inputDriver;
        this.outputDriver = outputDriver;
        this.library = library;
    }

    private boolean isValidInput(int choice) {
        return choice <= MainMenu.values().length && choice >= INDEX_OFFSET;
    }

    private void displayMenuChoice(int choice) {
        MainMenu.values()[choice - 1].act(library, inputDriver, outputDriver);
    }

    public void start() {
        outputDriver.printWelcomeMessage();
        outputDriver.printMainMenu();
    }

    public void performOnMenuChoice() {
        int choice = 0;
        while ((choice = getMainMenuChoice(inputDriver)) != MainMenu.values().length) {
            if (isValidInput(choice)) {
                displayMenuChoice(choice);
            } else {
                outputDriver.printInvalidMenuChoice();
            }
            outputDriver.printMainMenu();
        }
    }

    private int getMainMenuChoice(InputDriver inputDriver) {
        return inputDriver.getMenuChoiceFromUser();
    }
}
