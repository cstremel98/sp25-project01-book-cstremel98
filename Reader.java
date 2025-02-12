/**
 * Class which represents a library cardholder.
 * @author Charles Stremel
 */

public class Reader {
	//Double check
	public static final int CARD_NUMBER_ = 0;
	public static final int NAME_ = 1;
	public static final int PHONE_ = 2;
	public static final int BOOK_COUNT_ = 3;
	public static final int BOOK_START_ = 4;

	private int cardNumber;
	private String name;
	private String phone;
	private List<Book> books;

	public Reader(int cardNumber, String name, String phone) {
		this.cardNumber = cardNumber;
		this.name = name;
		this.phone = phone;
		books = new ArrayList<>();
	}

	//Double check
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Reader reader = (Reader) o;
		return cardNumber == reader.cardNumber && Objects.equals(name, reader.name) && Objects.equals(phone, reader.phone);
	}

	//Double check
	@Override
	public int hashCode() {
		return Objects.hash(cardNumber, name, phone);
	}

	@Override
	public String toString() {
		return name + "(#" + cardNumber + ") has checked out " + books;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<Book> getBooks() {
		return books; 
	}
	// Reference problem !
	public void setBooks(List<Book> books) {
		//Instantiation problem !
		this.books = new List<>();
		this.books = books;
	}
	public int getBookCount() {
		return books.size();
	}
	public boolean hasBook(Book book) {
		return books.contains(book);
	}
	public Code removeBook(Book book) {
		if (!books.contains(book) || books.isEmpty()) {
			return CODE.READER_DOESNT_HAVE_BOOK_ERROR;
		} else {
			return CODE.SUCCESS;
			books.remove(book);
		}
	}
	public Code addBook(Book book) {
		if books.contains(book) {
			return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
		} else {
			books.add(book);
			return Code.SUCCESS:
		}

	}

}
