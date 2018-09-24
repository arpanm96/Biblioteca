package controller;

import controller.action.AuthorisedUserAction;
import controller.action.ListCheckedOutItemsAction;
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
import model.user.UserAction;
import view.InputDriver;
import view.OutputDriver;

/*
An enum to display and initialize actions chosen by the user
*/

public enum MainMenu {
    LIST_BOOKS(Message.LIST_BOOKS, new ListBookAction(), AccessType.ALWAYS),
    LIST_MOVIES(Message.LIST_MOVIES, new ListMovieAction() , AccessType.ALWAYS),
    LOG_IN(Message.LOG_IN, new LogInAction(), AccessType.NOT_LOGGED_IN),
    CHECKOUT_BOOK(Message.CHECKOUT_BOOK, new AuthorisedUserAction(new CheckOutBookAction()), AccessType.LOGGED_IN),
    CHECKOUT_MOVIE(Message.CHECKOUT_MOVIE, new AuthorisedUserAction(new CheckOutMovieAction()), AccessType.LOGGED_IN),
    RETURN_BOOK(Message.RETURN_BOOK, new AuthorisedUserAction(new ReturnBookAction()), AccessType.LOGGED_IN),
    RETURN_MOVIE(Message.RETURN_MOVIE, new AuthorisedUserAction(new ReturnMovieAction()), AccessType.LOGGED_IN),
    LIST_CHECKED_OUT_ITEMS(Message.LIST_CHECKED_OUT_ITEMS, new AuthorisedUserAction(new ListCheckedOutItemsAction()), AccessType.LOGGED_IN),
    USER_INFORMATION(Message.USER_INFORMATION, new AuthorisedUserAction(new UserInformationAction()), AccessType.LOGGED_IN),
    LOG_OUT(Message.LOG_OUT, new LogOutAction(), AccessType.LOGGED_IN),
    QUIT(Message.QUIT, new QuitAction(), AccessType.ALWAYS) {
    };

    private String message;
    private Action action;
    private AccessType accessType;


    MainMenu(String message, Action action, AccessType accessType) {
        this.message = message;
        this.action = action;
        this.accessType = accessType;
    }

    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver, UserAction userAction) {
        this.action.act(library, inputDriver, outputDriver, userAction);
    }

    @Override
    public String toString() {
        return message;
    }
}

