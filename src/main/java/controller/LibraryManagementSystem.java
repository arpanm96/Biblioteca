package controller;

import model.Library;
import model.Book;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.Arrays;

/*
A class to drive together the whole library management system
*/

public class LibraryManagementSystem {
    private OutputDriver outputDriver;

    public LibraryManagementSystem(OutputDriver outputDriver) {
        this.outputDriver = new OutputDriver();
    }

    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new OutputDriver());
        Library library = new Library(new ArrayList<>(Arrays.asList(new Book("The Hobbit", "Tolkien", 1954))));
        libraryManagementSystem.displayInitial(library);
    }

    private void displayInitial(Library library) {
        outputDriver.printWelcomeMessage();
        outputDriver.printBookList(library);
    }
}
