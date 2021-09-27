package bookshopapp.bookshopartifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = controllers.BookController.class)
@ComponentScan(basePackageClasses = controllers.UsersController.class)
public class BookshopartifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopartifactApplication.class, args);
	}

}
