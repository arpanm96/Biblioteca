package controller;

import actionTest.*;
import actionTest.book.CheckOutBookAction;
import actionTest.book.ListBookAction;
import actionTest.book.ReturnBookAction;
import actionTest.movie.CheckOutMovieAction;
import actionTest.movie.ListMovieAction;
import actionTest.movie.ReturnMovieAction;
import common.Message;
import model.library.Library;
import view.InputDriver;
import view.OutputDriver;

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS, new ListBookAction()),
    LIST_MOVIES(Message.LIST_MOVIES, new ListMovieAction()),
    CHECKOUT_BOOK(Message.CHECKOUT_BOOK, new CheckOutBookAction()),
    CHECKOUT_MOVIE(Message.CHECKOUT_MOVIE, new CheckOutMovieAction()),
    RETURN_BOOK(Message.RETURN_BOOK, new ReturnBookAction()),
    RETURN_MOVIE(Message.RETURN_MOVIE, new ReturnMovieAction()),
    QUIT(Message.QUIT, new QuitAction()) {
    };

    private String message;
    public Action action;

    MainMenu(String message, Action action) {
        this.message = message;
        this.action = action;
    }

    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        this.action.act(library, inputDriver, outputDriver);
    }

    @Override
    public String toString() {
        return message;
    }
}

