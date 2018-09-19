import common.Message;

import java.util.List;

class Library {
    private List<Books> booksList;
    Library(OutputDriver outputDriver,List<Books> booksList) {
        this.booksList = booksList;
        outputDriver.printWelcomeMessage(Message.WELCOME);
        outputDriver.printBookList(booksList);
    }
}
