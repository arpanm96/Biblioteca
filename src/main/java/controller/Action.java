package controller;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public interface Action {
    void act(Library library, InputDriver inputDriver, OutputDriver outputDriver);
}
