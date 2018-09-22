import controller.LibraryManagementSystem;
import model.LibraryItemRepository;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

/*
A class to drive the whole Biblioteca application together
*/

public class Biblioteca {
    public static void main(String[] args) {
        InputDriver inputDriver = new InputDriver();
        OutputDriver outputDriver = new OutputDriver();
        Library library = new Library(new LibraryItemRepository().generateDefaultItemList());
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library);
        libraryManagementSystem.start();
        libraryManagementSystem.performOnMenuChoice();
    }
}
