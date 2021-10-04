package bookshopapp.bookshopartifact;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import bookshopapp.bookshopartifact.models.Users;

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

	@Test
	void userEndpointTest() throws Exception {
		Gson gson = new Gson();
		String jsonRequestBody = gson.toJson(generateFakeUser());
		this.mvc.perform(	
			get("/users/create")
			.contentType("application/json").content(jsonRequestBody)).andExpect(status().isForbidden());
	}

	@Test
	void contextLoads() {
	}

}
