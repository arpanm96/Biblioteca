package controller;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public class ListMenuAction implements Action {
    @Override
    public void act(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.printBookList(library.getLibraryBookDetails());
    }
}
