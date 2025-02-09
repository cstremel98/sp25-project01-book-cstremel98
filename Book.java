/**
 * Class which represents a book
 * @author Charles Stremel
 */

import java.time.LocalDate;
import java.util.Objects;

public class Book {
	public static final int ISBN_ = 0;
	public static final int TITLE_ = 1;
	public static final int SUBJECT_ = 2;
	public static final int PAGE_COUNT_ = 3;
	public static final int AUTHOR_ = 4;
	public static final int DUE_DATE_ = 5;

	private String isbn;
	private String title;
	private String subject;
	private String author;

	private int page_count;

	private LocalDate dueDate;

	public Book(String isbn, String title, String subject, String author, int page_count, LocalDate dueDate) {
		this.isbn = isbn;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.page_count = page_count;
		this.dueDate = dueDate;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return page_count == book.page_count && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(subject, book.subject) && Objects.equals(author, book.author);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn, title, subject, author, page_count);
	}

	@Override
	public String toString() {
		return title + " by " + author + " ISBN: " + isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage_count() {
		return page_count;
	}

	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}
}
