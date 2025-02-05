/**
 * Class which represents a book
 * @author Charles Stremel
 */

import java.util.LocalDate;

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

	public Book(){
		this.isbn = isbn;
	}

	@Override
	public final boolean equals(Object o) {
	}

	@Override
	public String toString() {
		return title + " by " + author + " ISBN: " + isbn;
	}

	public String getIsbn() {
		return isbn;
	}
	

}
