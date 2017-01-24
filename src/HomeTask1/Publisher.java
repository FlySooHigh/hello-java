package HomeTask1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Publisher 
{
	private String name;
	private List<Author> publishedAuthors;
	private List<Book> publishedBooks;
	
	public Publisher(String name, List<Author> publishedAuthors, List<Book> publishedBooks) {
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

	public List<Author> getPublishedAuthors() {
		return Collections.unmodifiableList(publishedAuthors);
	}

	public void setPublishedAuthors(List<Author> publishedAuthors) {
		this.publishedAuthors = publishedAuthors;
	}

	public List<Book> getPublishedBooks() {
		return new ArrayList<>(publishedBooks);			
	}

	public void setPublishedBooks(List<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}
	
	public List<Book> findAllBooks(Author author)
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
