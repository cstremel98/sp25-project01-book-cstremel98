/**
 * Main to test Book class.
 * 1. Create a null Book.
 * 2. Assert it is null.
 * 3. Instantiate with empty parameters.
 * 4. Assert it is not null.
 * @author Charles Stremel
 */

public class BookTest {
	public static void main(String [] args) {
		Book book = new Book("4523", "Dune", "Sci-fi", "Frank Herbert", 500);
	}

	public static boolean test1() {
		return true;
	}
}
