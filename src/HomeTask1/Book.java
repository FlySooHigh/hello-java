package HomeTask1;

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
		return new Author(author.getName(), author.getSurname(), author.getBirthdate());
	}

	public void setAuthor(Author author) {
		if (author == null){throw new NullPointerException();}
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
		return new Publisher(publisher.getName(), publisher.getPublishedAuthors(), publisher.getPublishedBooks());
	}

	public void setPublisher(Publisher publisher) {
		if (publisher == null){throw new NullPointerException();}
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
