import controller.LibraryManagementSystem;
import view.InputDriver;
import view.OutputDriver;

public class Biblioteca {
    public static void main(String[] args) {
        InputDriver inputDriver = new InputDriver();
        OutputDriver outputDriver = new OutputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver);
        libraryManagementSystem.start();
        libraryManagementSystem.performOnMenuChoice();
    }
}
