//import Books;

import java.util.List;

public class OutputDriver {
    public void printWelcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    public void printBookList(List<Books> booksList) {
        booksList.stream().forEach((books -> System.out.println(books)));
    }

}
