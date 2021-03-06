package bookshopapp.bookshopartifact;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = controllers.BookController.class)
@ComponentScan(basePackageClasses = controllers.BookController.class)
@ComponentScan(basePackageClasses = services.UserService.class)
@ComponentScan(basePackageClasses = controllers.WishlistController.class)


public class BookshopartifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopartifactApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// 	return args -> {

	// 		System.out.println("Let's inspect the beans provided by Spring Boot:");

	// 		String[] beanNames = ctx.getBeanDefinitionNames();
	// 		Arrays.sort(beanNames);
	// 		for (String beanName : beanNames) {
	// 			System.out.println(beanName);
	// 		}

	// 	};
	// }

}
