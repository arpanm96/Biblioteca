import model.Book;
import model.Item;
import model.LibraryItemRepository;
import model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryItemRepositoryTest {
    Book theHobbit;
    Book theLordOfTheRings;
    Movie shawshankRedemption;
    Movie se7en;
    LibraryItemRepository libraryItemRepository;
    Collection<Item> expectedList;

    @BeforeEach
    void initEach() {
        libraryItemRepository = new LibraryItemRepository();
        theHobbit = new Book("The Hobbit", "Tolkien", 1937);
        theLordOfTheRings = new Book("The Lord Of The Rings", "Tolkien", 1954);
        shawshankRedemption = new Movie("Shawshank Redemption", "Frank Darabont", 10, 1994);
        se7en = new Movie("Se7en", "David Fincher", 9, 1995);
    }

    @DisplayName("should return default generated list correctly")
    @Test
    void shouldReturnTrueForDefaultGenerateList() {
        expectedList = new ArrayList<Item>(Arrays.asList(theHobbit, theLordOfTheRings, shawshankRedemption, se7en));
        assertEquals(expectedList, libraryItemRepository.generateDefaultItemList());
    }
}

