package controller;

import common.Message;
import model.*;
import view.InputDriver;
import view.OutputDriver;

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS, new ListMenuAction());
/*    CHECKOUT(Message.CHECKOUT) {
        @Override
        public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
            Book bookToBeCheckedOut = new Book(inputDriver.getBookToBeCheckedOut());
            if(library.checkoutBook(bookToBeCheckedOut)){
                outputDriver.printBookCheckedOut();
            }
            else {
                outputDriver.printBookNotCheckedOut();
            }
        }
    },
    RETURN_BOOK(Message.RETURN_BOOK) {
        @Override
        public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
            Book bookToBeReturned =  new Book(inputDriver.getBookToBeReturned());
            if(library.returnBook(bookToBeReturned)){
                outputDriver.printBookReturned();
            }
            else {
                outputDriver.printBookNotReturned();
            }
        }
    },
    QUIT(Message.QUIT) {
        @Override
        public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        }
    };*/

    private String message;
    public Action action;

    MainMenu(String message, Action action ) {
        this.message = message;
        this.action = action;
    }

    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        this.action.act(library,inputDriver,outputDriver);
    }

    @Override
    public String toString() {
        return message;
    }
}

