import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class BookTest {

    Book book, book2, book3;
    Book nullBook;

    String isbn = "0123", isbn2 = "0456";
    String title = "How to Learn Java", title2 = "How to Learn to Swim";
    String subject = "Computer Science", subject2 = "Athletics";
    String author = "John McAfee", author2 = "John Carmac";
    int page_count = 500, page_count2 = 300;
    LocalDate dueDate = LocalDate.of(2025, 2, 9);

    @BeforeEach
    void setUp() {
        nullBook = null;
        book = new Book(isbn, title, subject, author, page_count, dueDate);
        book2 = new Book(isbn2, title2, subject2, page_count2, author2, dueDate);
        book3 = new Book(isbn2, title2, subject2, page_count2, author2, dueDate);
    }

    @AfterEach
    void tearDown() {
        book = null;
    }

    @Test
    void constructorTest() {
        assertEquals(nullBook, null);
        assertNotEquals(book, null);
    }

    @Test
    void testEquals() {
        assertNotEquals(book, book2);
        assertEquals(book2, book3);
    }

    @Test
    void getIsbn() {
        assertEquals(isbn, book.getIsbn());
    }

    @Test
    void setIsbn() {
        assertEquals(isbn, book.getIsbn());
        book.setIsbn(isbn2);
        assertNotEquals(isbn, book.getIsbn());
        assertEquals(book.getIsbn(), book2.getIsbn());
    }

    @Test
    void getTitle() {
        assertEquals(title, book.getTitle());
    }

    @Test
    void setTitle() {
        assertEquals(title, book.getTitle());
        book.setTitle(title2);
        assertNotEquals(title, book.getTitle());
        assertEquals(book.getTitle(), book2.getTitle());
    }

    @Test
    void getSubject() {
        assertEquals(subject, book.getSubject());
    }

    @Test
    void setSubject() {
        assertEquals(subject, book.getSubject());
        book.setSubject(subject2);
        assertNotEquals(subject, book.getSubject());
        assertEquals(book.getSubject(), book2.getSubject());
    }

    @Test
    void getAuthor() {
        assertEquals(author, book.getAuthor());
    }

    @Test
    void setAuthor() {
        assertEquals(author, book.getAuthor());
        book.setAuthor(author2);
        assertNotEquals(author, book.getAuthor());
        assertEquals(book.getAuthor(), book2.getAuthor());
    }

    @Test
    void getPage_count() {
        assertEquals(page_count, book.getPage_count());
    }

    @Test
    void setPage_count() {
        assertEquals(page_count, book.getPage_count());
        book.setPage_count(page_count2);
        assertNotEquals(page_count, book.getPage_count());
        assertEquals(book.getPage_count(), book2.getPage_count());
    }
}
