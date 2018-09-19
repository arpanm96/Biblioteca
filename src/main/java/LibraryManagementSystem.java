import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        OutputDriver outputDriver = new OutputDriver();
        Library library = new Library(outputDriver,new ArrayList<Books>());
    }
}
