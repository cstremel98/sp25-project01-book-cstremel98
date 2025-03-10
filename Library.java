/**
 * Class which represents a library, which includes Reader, Shelf, Book.
 * @author Charles Stremel
 */

import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class Library {
	public int LENDING_LIMIT;

	private int libraryCard;	
	private String name;
	
	private HashMap<Book, Integer> books;
	private HashMap<String, Shelf> shelves;
	private List<Reader> readers;
	
	private List<Book> bookCpy;
	private List<Shelf> shelfCpy;

	public Library(String name) {
		this.name = name;
		books = new HashMap<>();
		shelves = new HashMap<>();
		readers = new ArrayList<>();
	
		bookCpy = new ArrayList<>();
		shelfCpy = new ArrayList<>();
	}

	public boolean init(String filename) {
		Scanner s = null;
		File file = new File(filename);
		
		try {
			s = new Scanner(file);
			
			int cnt = s.nextInt();
			System.out.println("Books in " + filename + ": " + cnt);
			initBooks(cnt, s);
			
			cnt = s.nextInt();
			System.out.println("Shelves in " + filename + ": " + cnt);
			initShelves(cnt, s);

			cnt = s.nextInt();
			System.out.println("Readers in " + filename + ": " + cnt);
			initReader(cnt, s);
		
			return true;
		
		} catch (FileNotFoundException e) {
			System.out.printf("Could not read %s $n", filename);
			return false;
		} finally {
			System.out.println("Successful initialization.");
			return true;
		}
	}

	public boolean returnBook(Book book) {
		if(shelves.get(book.getSubject() != null) {
			int bookCount = books.get(book);
			books.put(book, bookCount+1);
			System.out.println("Successfully returned book.");
			return true;
		} else {
			System.out.println("");
			return false;
		}
	}

	public boolean removeReader(Reader reader) {
		for(int i=0; i<readers.size(); i++) {
			if(readers.get(i) == reader) {
				readers.remove(i);
				System.out.println("Successfully removed " + reader.getName());
				return true;
			}
		}
		System.out.println("Could not find " + reader.getName());
		return false;
	}

	//@Change change to CODE
	public boolean checkOutBook(Reader reader, Book book) {
		for(int i=0; i<readers.size(); i++) {
			if(readers.get(i) == reader) {
				//System.out.println(reader.getName() + " found.");
				i=readers.size();
			} 
		}
		//System.out.println(books.get(book));
		
		if(books.get(book) < 1) {
			System.out.println("No more copies of " + book.getTitle() + ".");
			return false;
		} else if (reader.hasBook(book)) {
			System.out.println(reader.getName() + " already has a copy of " + book.getTitle() + ".");
			return false;
		}
		
		reader.addBook(book);
		int bookCount = books.get(book);
		books.put(book, bookCount-1);
		shelves.get(book.getSubject()).removeBook(book);	
		
		System.out.println("Successful checkout.");
		return true;
	}

	//@Change change to CODE
	public boolean addReader(Reader reader) {
		for(int i=0; i<readers.size(); i++) {
			if(readers.get(i) == reader) {
				System.out.println(reader.getName() + " already exists.");
				return false;
			}	
		}
		System.out.println("Successfully added " + reader.getName());
		readers.add(reader);
		return true;
	}

	//@Change change to CODE
	public boolean addBook(Book newBook) {
		int x = 1;
		System.out.println("Add " + newBook);
		if(books.get(newBook) != null) {
			books.put(newBook,x+1);
			bookCpy.add(newBook);
		
			for(int i=0; i<shelfCpy.size(); i++) {
				if(shelfCpy.get(i).getSubject().equals(newBook.getSubject())) {
					(shelves.get(newBook.getSubject())).addBook(newBook); 
				}
			}

				
			return true;
		} else {
			books.put(newBook,1);
			bookCpy.add(newBook);
			for(int i=0; i<shelfCpy.size(); i++) {
				if(shelfCpy.get(i).getSubject().equals(newBook.getSubject())) {
					(shelves.get(newBook.getSubject())).addBook(newBook); 
				}
			}
		}
		return false;
	}
	//@Change change to CODE
	public boolean addShelf(String shelfSubject) {
		if(shelves.get(shelfSubject) == null) {
			Shelf tmp = new Shelf(shelfCpy.size()+1, shelfSubject);
			
			shelfCpy.add(tmp);

			shelves.put(shelfSubject, tmp);
			System.out.println("Success." + "\n");
			return true;
		}
		System.out.println("Shelf exists." + "\n");
		return false;

	}
	//@Change change to CODE
	public boolean addShelf(Shelf shelf) {
		if(shelves.get(shelf.getSubject()) == null) {
			shelfCpy.add(shelf);
			
			shelves.put(shelf.getSubject(), shelf);
			System.out.println("Success." + "\n");
			return true;
		}
		System.out.println("Shelf exists." + "\n");
		return false;

	}

	public Book getBookByISBN(String isbn) {
		for(int i=0; i<bookCpy.size(); i++) {
			if(isbn.equals(bookCpy.get(i).getIsbn())) {
				return bookCpy.get(i);
			}	
		}
		return null;
	}
	public int getLibraryCardNumber() {
		return libraryCard;
	}
	public String getName() {
		return name;	
	}
	public Reader getReaderByCard(int cardNumber) {
		for(int i=0; i<readers.size(); i++) {
			if(cardNumber == readers.get(i).getCardNumber()) {
				System.out.println("Success.");
				return readers.get(i);
			}
		}
		System.out.println("Could not find reader " + cardNumber);
		return null;
	}
	public Shelf getShelf(String subject) {
		System.out.println("Get shelf subject " + subject);
		if(shelves.get(subject) != null) {
			System.out.println("Success." + "\n");
			return shelves.get(subject);	
		}
		System.out.println("Not found." + "\n");
		return null;
	}
	public Shelf getShelf(Integer shelfNumber) {
		System.out.println("Get shelf #" + shelfNumber);
		for(int i=0; i<shelfCpy.size(); i++) {
			if(shelfCpy.get(i).getShelfNumber() == shelfNumber) {
				System.out.println("Success." + "\n");
				return shelfCpy.get(i);
			}
		}
		System.out.println("Not found." + "\n");
		return null;
	}
	
	public int listShelves(boolean showBooks) {
		Collection<String> colSh = shelves.keySet();
		colSh.toArray();
		for(int i=0; i<colSh.toArray().length; i++) {
			Shelf tmp = shelves.get(colSh.toArray()[i]);
			System.out.println(tmp);
			System.out.println(tmp.listBooks());
		}
		return shelves.size();
	}
	public int listShelves() {
		System.out.println(shelves.values());
		return shelves.size();
	}
	public int listReaders(boolean showBooks) {
		for(int i=0; i<readers.size(); i++) {
			Reader tmp = readers.get(i);
			System.out.println(tmp);
		}
		return readers.size();
	}
	public int listReaders() {
		for(int i=0; i<readers.size(); i++) {
			Reader tmp = readers.get(i);
			System.out.println(tmp.getName());
		}
		return readers.size();
	}
	public int listBooks() {
		System.out.println(books);
		return books.size();

	}

	//@Change change to CODE
	private boolean initReader(int readerCount, Scanner s) {
		LocalDate dueDate = LocalDate.of(2025, 3, 8);
		s.nextLine();
		
		for(int i=0; i<readerCount; i++) {
			String string = s.nextLine();
			String [] strings = string.split(",");
			
			int tmpNum = 999;
			String tmpName = "X";
			String tmpPhone = "000";
			List<Book> tmpBooks = new ArrayList<>();
			int tmpBCount = 0, tmpBStart = 0;

			int y=0;
			while(y<strings.length) {
				System.out.println("ROUND " + i);
				tmpNum = Integer.parseInt(strings[y]);
				y++;
				tmpName = strings[y];
				y++;
				tmpPhone = strings[y];
				y++;
				tmpBCount = Integer.parseInt(strings[y]);
				y++;
				if(tmpBCount == 2) {
					Book tmpBook = new Book(strings[y], "title", "sub", 00, "author", dueDate);
					for(int j=0; j<bookCpy.size(); j++) {
						if(strings[y].equals(bookCpy.get(j).getIsbn())) {
							tmpBook = bookCpy.get(j);
						}
					}
					tmpBooks.add(tmpBook);
					y++;
					String dueDate1 = strings[y];
					System.out.println("ADDED 1st BOOK.");	
					if(y == strings.length-1) {
						System.out.println("MOVING ON.");
						y++;
					} else {
						y++;
						
						tmpBook = new Book(strings[y], "title", "sub", 00, "author", dueDate);
						for(int j=0; j<bookCpy.size(); j++) {
							if(strings[y].equals(bookCpy.get(j).getIsbn())) {
								tmpBook = bookCpy.get(j);
							}
						}
						tmpBooks.add(tmpBook);
						y++;
						String dueDate2 = strings[y];	
						y++;
					}
				} else {
					System.out.println("ONLY 1 BOOK.");
					Book tmpBook = new Book(strings[y], "title", "sub", 00, "author", dueDate);
					tmpBooks.add(tmpBook);
					y++;
					String dueDate1 = strings[y];
					y++;
				}	
			}
			System.out.println("ADDED " + i + " now at end.");
			Reader tmp = new Reader(tmpNum, tmpName, tmpPhone);
			tmp.setBooks(tmpBooks);
			readers.add(tmp);
		}
		return true;	
	}

	//@Change change to CODE
	private boolean initShelves(int shelfCount, Scanner s) {
		s.nextLine();
		
		for(int i=0; i<shelfCount; i++) {
			String string = s.nextLine();
			String [] strings = string.split(",");
			
			int tmpNum = 999;
			String tmpSub = "X";	
			for(int j=0; j<strings.length; j++) {
				if(j==0) {
				tmpNum = Integer.parseInt(strings[j]);	
				}
				tmpSub = strings[j];
			}
			Shelf tmp = new Shelf(tmpNum, tmpSub);
			for(int j=0; j<bookCpy.size(); j++) {
				if(tmpSub.equals(bookCpy.get(j).getSubject())) {
					tmp.addBook(bookCpy.get(j));	
				}
			}
			shelves.put(tmpSub, tmp);
			shelfCpy.add(tmp);
		}
		return true;
	}

	//@Change change to CODE
	private boolean initBooks(int bookCount, Scanner s) {
		LocalDate dueDate = LocalDate.of(2025, 3, 8);
		s.nextLine();
		
		for(int i=0; i<bookCount; i++) {
			Book tmp = new Book("isbn", "title", "subject", 00, "author", dueDate);
			String string = s.nextLine();
			String [] strings = string.split(",");
			
			int cnt = 1;

			int y=0;
			while(y<5) {	
				tmp.setIsbn(strings[y]);
				y++;
				tmp.setTitle(strings[y]);
				y++;
				tmp.setSubject(strings[y]);
				y++;
				tmp.setPage_count(Integer.parseInt(strings[y]));
				y++;
				tmp.setAuthor(strings[y]);
				y++;
			}
			if(books.get(tmp) != null) {
				cnt += books.get(tmp);
			}
			books.put(tmp, cnt);
			bookCpy.add(tmp);
		}
		return true;
	}
}
