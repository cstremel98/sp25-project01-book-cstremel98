/**
 * Class which represents shelf in a library.
 * @author Charles Stremel
 */

import java.util.HashMap;

public class Shelf {
	//Double check
	public static final int SHELF_NUMBER_ = 0;
	public static final int SUBJECT_ = 1;

	private HashMap<Book, Integer> books;
	private int shelfNumber;
	private String subject;

	public Shelf(int shelfNumber, String subject) {
		this.shelfNumber = shelfNumber;
	}
	
	public Code addBook(Book book) {		
		int x = books.get(book);
		if(books.get(book) != null) {
			books.put(book, x+1);
			return CODE.SUCCESS;
		}
	}

	//Double check
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Shelf shelf = (Shelf) o;
		return shelfNumber == shelf.shelfNumber && Objects.equals(subject, shelf.subject);
	}
	
	public int getBookCount(Book book) {
		if(books.get(book) != null) {
			return books.get(book);
		} else {
			return -1;
		}
	}	
	
	public HashMap<Book, Integer> getBooks() {
		return books;
	}
	
	public int getShelfNumber() {
		return shelfNumber;
	}

	public String getSubject() {
		return subject;
	}
	
	//Double check
	@Override
	public int hashCode() {
		return Objects.hash(shelfNumber, subject);
	}
	
	public String listBooks() {
		System.out.println(books);
	}
	
	public Code removeBook(Book book) {
		int x = books.get(book);
		books.put(book, x-1);
	
	}
	
	public void setBooks(HashMap<Book, Integer> books) {
		this.books = books;
	}
	
	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}
	
	@Override
	public String toString() {
		return shelfNumber + " : " + subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
