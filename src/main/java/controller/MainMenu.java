package controller;

import common.Message;
import model.Library;
import view.OutputDriver;

import java.util.ArrayList;

public enum MainMenu {
    QUIT("Quit") {
        @Override
        public void act(Library library) {
        }
    },
    LIST_BOOKS(Message.LIST_BOOKS) {
        @Override
        public void act(Library library) {
            new OutputDriver().printBookList(new ArrayList<>(library.getLibraryBookDetails()));
        }
    };

    private String message;

    MainMenu(String message) {
        this.message = message;
    }

    public abstract void act(Library library);

    @Override
    public String toString() {
        return message;
    }
}

