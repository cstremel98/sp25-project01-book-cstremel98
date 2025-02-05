/**
 * Class which represents a book
 * @author Charles Stremel
 */

import java.time.LocalDate;

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
	private int pageCount;
	private LocalDate dueDate;

	public Book(String isbn, String title, String subject, String author, int pageCount){
		this.isbn = isbn;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.pageCount = pageCount;
	}

	@Override
	public final boolean equals(Object o) {
		if(this == o) {
			return true;
		}	
		if(o == null || getClass() != o.getClass()) {
			return false;
		}

		Book book = (Book) o;

		if(getPageCount() != book.getPageCount()) {
			return false;
		}
		//WIP
		if(getISBN() != null ? !getISBN().equals(book.getISBN()) : book.getISBN != null ...)
			return false;
		}
	}

	@Override
	public String toString() {
		return title + " by " + author + " ISBN: " + isbn;
	}

	public String getAuthor() {
		return isbn;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public String getISBN() {
		return isbn;
	}
	public String getPageCount() {
		return isbn;
	}
	public String getSubject() {
		return isbn;
	}
	public String getTitle() {
		return isbn;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
