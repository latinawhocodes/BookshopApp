package controllers;

import models.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
	
	@GetMapping ("/books/Top10")
	List <Book> getTop10Sellers () {
		List <Book> books = Book.GetAllBooks();
		Collections.sort(books, (o1, o2) -> -1 * Integer.compare(o1.getCopiesSold(), o2.getCopiesSold()));
		return books.subList(0, Math.min(books.size(), 10));
	}
	
    @GetMapping("/books/rating/{rating}")
    List <Book> getRatedOrHigher (@PathVariable int rating) {
        List <Book> books = Book.GetBooksWithRatingAndHigher(rating);
        Collections.sort(books, (o1, o2) -> -1 * Double.compare(o1.getRating(), o2.getRating()));
        return books;
    }
}
