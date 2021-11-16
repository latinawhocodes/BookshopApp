package bookshopapp.bookshopartifact;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import models.Book;


import models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;

@SpringBootTest
@AutoConfigureMockMvc

class BookshopartifactApplicationTests {

	@Autowired
	private MockMvc mvc;

	private Users generateFakeUser() {
		return new Users(2, "fake@email.com", "fakePassword");
	}

		private Users generateFakeUserForUpdateRequest() {
		return new Users(2, "fake@email.com", "fakePassword123");
	}

	@Test
	void userEndpointTest() throws Exception {
		Gson gson = new Gson();
		String jsonRequestBody = gson.toJson(generateFakeUser());
		this.mvc.perform(	
			get("/users/create")
			.contentType("application/json").content(jsonRequestBody)).andExpect(status().isOk());
	}

	@Test
	void updateUserEndpointTest() throws Exception {
		Gson gson = new Gson();
		String jsonRequestBody = gson.toJson(generateFakeUserForUpdateRequest());
		this.mvc.perform(	
			get("/users/update")
			.contentType("application/json").content(jsonRequestBody)).andExpect(status().isOk());
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
