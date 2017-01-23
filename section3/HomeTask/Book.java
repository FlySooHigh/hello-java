package HomeTask;

public class Book 
{
	private Author author;
	private String title;
	private int year;
	private Publisher publisher;
	private int ISBN;
	private double price;
	
	public Book(Author author, String title, int year, Publisher publisher, int iSBN, double price) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.publisher = publisher;
		ISBN = iSBN;
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
