import java.time.LocalDate;

/**
 * This is the main 'driver' it is used to run the files and get the output seen in the prompt.
 * @author Drew "Dr.C" Clinkenbeard
 */

public class Main {
    public static void main(String[] args) {

        Library csumb = new Library("CSUMB");
        csumb.init("Library01.csv");
	int numb = csumb.listBooks();
        System.out.println("total books: " + numb);
	System.out.println();
        
	numb = csumb.listReaders(true);
        System.out.println("total readers: " + numb );
	System.out.println();
	numb = csumb.listReaders();
        System.out.println("total readers: " + numb );
	System.out.println();
        
	System.out.println("total shelves: " + csumb.listShelves(true));
        
	Book bestServedCold = new Book("12345","Best Served Cold","GrimDark",235,"Joe Abercrombie",LocalDate.now());
        Shelf scifi = csumb.getShelf("sci-fi");
	
	scifi.addBook(bestServedCold);
        csumb.addBook(bestServedCold);
        csumb.addBook(bestServedCold);
       
	System.out.println("SCIFI BOOKS: " + scifi.listBooks());
	System.out.println("CSUMB BOOKS: " + csumb.listBooks());
	System.out.println("CSUMB SHELF: " + csumb.listShelves());	

	csumb.addShelf("GrimDark");
	System.out.println("CSUMB SHELF: " + csumb.listShelves());	
        
	csumb.addBook(bestServedCold);
	csumb.addBook(bestServedCold);
	csumb.addBook(bestServedCold);
        
	System.out.println("CSUMB BOOKS: " + csumb.listBooks());
        csumb.listShelves(true);
        
	csumb.listReaders(true);
	Reader drew = csumb.getReaderByCard(1);
       
	csumb.addReader(drew);
	csumb.addReader(drew);
	Reader Jamea = new Reader(123, "Jameaa", "9494994901");
	csumb.addReader(Jamea);
	csumb.addReader(Jamea);
        csumb.listShelves(true);

	csumb.checkOutBook(drew,bestServedCold);
	csumb.checkOutBook(drew,bestServedCold);
	csumb.checkOutBook(drew,bestServedCold);
	csumb.checkOutBook(drew,bestServedCold);
	csumb.checkOutBook(drew,bestServedCold);
        
	csumb.listReaders(true);
        csumb.listShelves(true);
        
	System.out.println(csumb.getBookByISBN("42-w-87"));

	/*csumb.returnBook(drew,csumb.getBookByISBN("42-w-87"));
        csumb.returnBook(drew,csumb.getBookByISBN("42-w-87"));
	*/
    }
}
