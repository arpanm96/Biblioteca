import model.BookRepository;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryTest {
    BookRepository bookRepository;

    @BeforeEach
    void initEach() {
        bookRepository = new BookRepository();
    }

    @DisplayName("should return default generated list correctly")
    @Test
    void shouldReturnTrueForDefaultGenerateList() {
        assertEquals(bookRepository.generateDefaultBookList(), new ArrayList<>(Arrays.asList("The Hobbit,Tolkien,1937", "The Lord Of The Rings,Tolkien,1954")));
    }
}

