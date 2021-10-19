package controllers;

import models.Book;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@GetMapping ("/books/{genre}")
	List <Book> getBooksByGenre (@PathVariable String genre) {
		List <Book> books = Book.GetAllBooks();
		List <Book> filteredBooks = new ArrayList <Book> ();
		for (Book b : books) {
			if (b.getGenre ().toLowerCase ().equals(genre.toLowerCase ())) {
				filteredBooks.add(b);				
			}
		}
		return filteredBooks;
	}

	
	@GetMapping ("/books/ISBN/{ISBN}")
	List <Book> getBooksByISBN (@PathVariable String ISBN) {
		List <Book> books = Book.GetAllBooks();
		List <Book> filteredBooks = new ArrayList <Book> ();
		for (Book b : books) {
			if (b.getISBN ().equalsIgnoreCase (ISBN)) {
				filteredBooks.add(b);				
			}
		}
		return filteredBooks;
	}
	
}
