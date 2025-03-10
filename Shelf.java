/**
 * Class which represents shelf in a library.
 * @author Charles Stremel
 */

import java.util.HashMap;

public class Shelf {
	public static final int SHELF_NUMBER_ = 0;
	public static final int SUBJECT_ = 1;

	private HashMap<Book, Integer> books;
	private int shelfNumber;
	private String subject;

	public Shelf(int shelfNumber, String subject) {
		this.shelfNumber = shelfNumber;
		this.subject = subject;
		books = new HashMap<>();
	}
	
	public boolean addBook(Book book) {
		int x;	
		
		if(books.get(book) == null) {
			x = 0;
		} else {
			x = books.get(book);
		}

		System.out.println("ADDING");
		if(books.get(book) != null) { 
			books.put(book, x+1);
			System.out.println(books.get(book));
			return true;
			//return CODE.SUCCESS;
		} else {
			books.put(book, 1);
			System.out.println(books.get(book));
			return false;
		}
	}

	/*
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Shelf shelf = (Shelf) o;
		return shelfNumber == shelf.shelfNumber && Objects.equals(subject, shelf.subject);
	}*/
	
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
	
	/*
	//Double check
	@Override
	public int hashCode() {
		return Objects.hash(shelfNumber, subject);
	}*/
	
	public String listBooks() {
		return books.toString();
	}
	
	public boolean removeBook(Book book) {
		int x = books.get(book);
		books.put(book, x-1);
		return true;
	}
	
	public void setBooks(HashMap<Book, Integer> books) {
		this.books = books;
	}
	
	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}
	
	@Override
	public String toString() {
		return "#" + shelfNumber + ": " + subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
