package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import models.Author;
import services.AuthorService;
import java.util.List;
import java.util.ArrayList;
 
@RestController
public class AuthorController {
 
    private final AuthorService authorService;
 
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    @GetMapping("/author/create")
    public Author create(@RequestBody Author author) {
        Author.saveAuthor(author);
        return author;
    }
/*    
    @GetMapping ("/author/{authorFirstName}")
	List <Author> getAuthors (@PathVariable String authorFirstName) {
		List <Author> authors = Author.GetAllAuthors();
		List <Author> filteredAuthors = new ArrayList <Author> ();
		for (Author a : authors) {
			if (a.getAuthorFirstName().toLowerCase ().equals(authorFirstName.toLowerCase ())) {
				filteredAuthors.add(a);				
			}
		}
		return filteredAuthors;
	}
    */
}
