package controllers;

import models.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping ("/books/Author/{Author}")
	List <Book> getBooksByAuthor (@PathVariable String Author) {
		List <Book> books = Book.GetAllBooks();
		List <Book> filteredBooks = new ArrayList <Book> ();
		for (Book b : books) {
			if (b.getAuthor ().equalsIgnoreCase (Author)) {
				filteredBooks.add(b);				
			}
		}
		return filteredBooks;
	}	
    
    @GetMapping ("/books/top10")
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
    
    @GetMapping("/books/paging/{numberOfBooks}")
    ResponseEntity<List <Book>> getBooksPaged (@PathVariable int numberOfBooks, @RequestParam(required = false) Integer page) {
        List <Book> books = Book.GetAllBooks();
        Collections.sort(books, (o1, o2) -> -1 * Integer.compare(o1.getCopiesSold(), o2.getCopiesSold()));
        
        if (numberOfBooks > books.size() || numberOfBooks < 1)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        
        if (page == null)
            return new ResponseEntity<>(books.subList(0, numberOfBooks), HttpStatus.OK);
        
        int fromIndex = (page - 1) * numberOfBooks; // Cannot exceed the number of books in the record set
        int toIndex = Math.min(page * numberOfBooks, books.size()); // Capped at the size of the record set of books
        
        if (fromIndex >= books.size())
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        
        return new ResponseEntity<>(books.subList(fromIndex, toIndex), HttpStatus.OK);
    }
}