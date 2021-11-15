package bookshopapp.bookshopartifact;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import models.Book;

@SpringBootTest
class BookshopartifactApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testBook() {
		Book book = new Book("9781974710027", "Jujutsu Kaisen, Vol. 1", "Some guy ate a demon's finger", 9.99, "Gege Akutami", "Manga", "VIZ Media LLC", 2019, 50000000);
		assertEquals("9781974710027", book.getISBN());
		assertEquals("Jujutsu Kaisen, Vol. 1", book.getName());
		assertEquals("Some guy ate a demon's finger", book.getDescription());
		assertEquals("Gege Akutami", book.getAuthor());
		assertEquals("Manga", book.getGenre());
		assertEquals("VIZ Media LLC", book.getPublisher());
		assertEquals(2019, book.getYearPublished());
		assertEquals(50000000, book.getCopiesSold());
	}

	
}
