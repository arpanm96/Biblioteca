package controller;

import action.*;
import common.Message;
import model.*;
import view.InputDriver;
import view.OutputDriver;

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS, new ListBookAction()),
    LIST_MOVIES(Message.LIST_MOVIES, new ListMovieAction()),
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

