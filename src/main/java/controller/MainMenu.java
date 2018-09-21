package controller;

import common.Message;
import model.*;
import view.InputDriver;
import view.OutputDriver;

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS) {
        @Override
        public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
            outputDriver.printBookList(library.getLibraryBookDetails());
        }
    },
    CHECKOUT(Message.CHECKOUT) {
        @Override
        public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
            Book bookToBeCheckedOut = new Book(inputDriver.getBookToBeCheckedOut());
            if (library.checkoutBook(bookToBeCheckedOut)) {
                outputDriver.printBookCheckedOut();
            } else {
                outputDriver.printBookNotCheckedOut();
            }
        }
    },
    RETURN_BOOK(Message.RETURN_BOOK) {
        @Override
        public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
            Book bookToBeReturned = new Book(inputDriver.getBookToBeReturned());
            if (library.returnBook(bookToBeReturned)) {
                outputDriver.printBookReturned();
            } else {
                outputDriver.printBookNotReturned();
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

