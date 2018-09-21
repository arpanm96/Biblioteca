package controller;

import common.Message;
import model.Library;
import view.OutputDriver;

public enum MainMenu {
    QUIT("Quit") {
        @Override
        public void act(Library library, OutputDriver outputDriver) {
        }
    },
    LIST_BOOKS(Message.LIST_BOOKS) {
        @Override
        public void act(Library library, OutputDriver outputDriver) {
            outputDriver.printBookList(library.getLibraryBookDetails());
        }
    };

    private String message;

    MainMenu(String message) {
        this.message = message;
    }

    public abstract void act(Library library, OutputDriver outputDriver);

    @Override
    public String toString() {
        return message;
    }
}

