package controller;

import common.Message;
import model.*;
import view.InputDriver;
import view.OutputDriver;

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS, new ListMenuAction()),
    CHECKOUT(Message.CHECKOUT, new CheckOutBookAction()),
    RETURN_BOOK(Message.RETURN_BOOK, new ReturnBookAction()),
    QUIT(Message.QUIT, new QuitAction()) {
    };

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

