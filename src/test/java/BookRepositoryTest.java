import model.Book;
import model.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookRepositoryTest {
    Book theHobbit;
    Book theLordOfTheRings;
    BookRepository bookRepository;
    Collection<Book> expectedList;

    @BeforeEach
    void initEach() {
        bookRepository = new BookRepository();
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
    }

    @DisplayName("should return default generated list correctly")
    @Test
    void shouldReturnTrueForDefaultGenerateList() {
        expectedList = new ArrayList<>(Arrays.asList(theHobbit, theLordOfTheRings));
        assertEquals(bookRepository.generateDefaultBookList(), expectedList);
    }
}

