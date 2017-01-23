package HomeTask;

import java.util.ArrayList;

public class HomeTaskDemo 
{
	public static void main(String[] args) 
	{
		Author author1 = new Author("William", "Shakespear", "1564");	
		Author author2 = new Author("Dale", "Carnegie", "1888");
		
		ArrayList<Author> authorList1 = new ArrayList<>();
		authorList1.add(author1);
		
		ArrayList<Book> bookList1 = new ArrayList<>();
		
		Publisher publisher1 = new Publisher("NumberOne", authorList1, bookList1);
		
		Book book1 = new Book(author1, "Java", 2000, publisher1, 1001, 9.99);
		Book book2 = new Book(author1, "Java2", 2001, publisher1, 1002, 19.99);
		Book book3 = new Book(author2, "Python", 2002, publisher1, 1003, 10.99);
		
		bookList1.add(book1);
		bookList1.add(book2);
		bookList1.add(book3);
		
		ArrayList<Book> foundBooks = publisher1.findAllBooks(author1);
		
		for (Book book : foundBooks)
		{
			System.out.println(book.getTitle());
		}
	}
}
