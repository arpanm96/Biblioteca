package controller;

import controller.action.AuthorisedUserAction;
import controller.action.user.LogInAction;
import controller.action.QuitAction;
import controller.action.book.CheckOutBookAction;
import controller.action.book.ListBookAction;
import controller.action.book.ReturnBookAction;
import controller.action.movie.CheckOutMovieAction;
import controller.action.movie.ListMovieAction;
import controller.action.movie.ReturnMovieAction;
import controller.action.user.LogOutAction;
import common.Message;
import model.library.Library;
import model.user.UserAccount;
import view.InputDriver;
import view.OutputDriver;

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS, new ListBookAction()),
    LIST_MOVIES(Message.LIST_MOVIES, new ListMovieAction()),
    LOG_IN(Message.LOG_IN, new LogInAction()),
    CHECKOUT_BOOK(Message.CHECKOUT_BOOK, new AuthorisedUserAction(new CheckOutBookAction())),
    CHECKOUT_MOVIE(Message.CHECKOUT_MOVIE, new AuthorisedUserAction(new CheckOutMovieAction())),
    RETURN_BOOK(Message.RETURN_BOOK, new AuthorisedUserAction(new ReturnBookAction())),
    RETURN_MOVIE(Message.RETURN_MOVIE, new AuthorisedUserAction(new ReturnMovieAction())),
    LOG_OUT(Message.LOG_OUT,new LogOutAction()),
    QUIT(Message.QUIT, new QuitAction()) {
    };

    private String message;
    public Action action;

    MainMenu(String message, Action action) {
        this.message = message;
        this.action = action;
    }

    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAccount userAccount) {
        this.action.act(library, inputDriver, outputDriver, userAccount);
    }

    @Override
    public String toString() {
        return message;
    }
}

