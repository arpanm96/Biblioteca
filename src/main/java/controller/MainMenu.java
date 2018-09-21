package controller;

import common.Message;
import model.*;
import view.InputDriver;
import view.OutputDriver;

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS) {
        @Override
        public void act(Library library, InputDriver inputDriver,OutputDriver outputDriver) {
            outputDriver.printBookList(library.getLibraryBookDetails());
        }
    },
    CHECKOUT(Message.CHECKOUT) {
        @Override
        public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
            Book checkoutBook = new Book(inputDriver.getBookToBeCheckedOut());
            if(library.removeBook(checkoutBook)){
                outputDriver.printBookCheckedOut();
            }
            else {
                outputDriver.printBookNotCheckedOut();
            }
        }
    },
    QUIT(Message.QUIT) {
        @Override
        public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        }
    };

    private String message;

    MainMenu(String message) {
        this.message = message;
    }

    public abstract void act(Library library, InputDriver inputDriver, OutputDriver outputDriver);

    @Override
    public String toString() {
        return message;
    }
}

