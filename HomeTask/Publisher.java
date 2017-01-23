package HomeTask;

import java.util.ArrayList;

public class Publisher 
{
	private String name;
	private ArrayList<Author> publishedAuthors;
	private ArrayList<Book> publishedBooks;
	
	public Publisher(String name, ArrayList<Author> publishedAuthors, ArrayList<Book> publishedBooks) {
		this.name = name;
		this.publishedAuthors = publishedAuthors;
		this.publishedBooks = publishedBooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Author> getPublishedAuthors() {
		return publishedAuthors;
	}

	public void setPublishedAuthors(ArrayList<Author> publishedAuthors) {
		this.publishedAuthors = publishedAuthors;
	}

	public ArrayList<Book> getPublishedBooks() {
		return (ArrayList<Book>) publishedBooks.clone();			// Would this add immutability ?
		// return publishedBooks;
	}

	public void setPublishedBooks(ArrayList<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}
	
	public ArrayList<Book> findAllBooks(Author author)
	{
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book : publishedBooks)
		{
			if (author.equals(book.getAuthor()))
			{
				result.add(book);
			}
		}
		return result;
	}
}
