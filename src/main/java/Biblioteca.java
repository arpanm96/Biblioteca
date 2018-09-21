import controller.LibraryManagementSystem;
import view.InputDriver;
import view.OutputDriver;

/*
A class to drive the whole Biblioteca application together
*/

public class Biblioteca {
    public static void main(String[] args) {
        InputDriver inputDriver = new InputDriver();
        OutputDriver outputDriver = new OutputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver);
        libraryManagementSystem.start();
        libraryManagementSystem.performOnMenuChoice();
    }
}
