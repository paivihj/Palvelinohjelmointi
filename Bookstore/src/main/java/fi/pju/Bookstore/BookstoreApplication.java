package fi.pju.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.pju.Bookstore.domain.Book;
import fi.pju.Bookstore.domain.BookRepository;
import fi.pju.Bookstore.domain.Category;
import fi.pju.Bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner customerDemo(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {
			log.info("Save categories and books");
			cRepository.save(new Category("History"));
			cRepository.save(new Category("Entertainment"));
			
			bRepository.save(new Book("Seitsemän veljestä", "Aleksis Kivi", 1870, "XY000123", 19.90, cRepository.findByName("History").get(0)));
			bRepository.save(new Book("Seitsemän sisarta", "Lucinda Riley", 2013, "AB000456", 19.90, cRepository.findByName("Entertainment").get(0)));
			
			log.info("Fetch books");
			for (Book book : bRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
