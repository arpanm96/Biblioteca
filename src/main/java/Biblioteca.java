import controller.LibraryManagementSystem;
import model.BookRepository;
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
        Library library = new Library(new BookRepository().generateDefaultItemList());
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(inputDriver, outputDriver, library);
        libraryManagementSystem.start();
        libraryManagementSystem.performOnMenuChoice();
    }
}
