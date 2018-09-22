package controller;

import action.*;
import action.book.CheckOutBookAction;
import action.book.ListBookAction;
import action.book.ReturnBookAction;
import action.movie.CheckOutMovieAction;
import action.movie.ListMovieAction;
import action.movie.ReturnMovieAction;
import common.Message;
import model.*;
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

