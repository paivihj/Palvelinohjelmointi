package fi.pju.Bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.pju.Bookstore.domain.Book;
import fi.pju.Bookstore.domain.BookRepository;
import fi.pju.Bookstore.domain.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	public void insertBook() {
		Book book = new Book("Hennig Mankell TEST", "Kasvoton kuolema TEST", 2021, "XXX", 8.90,
				categoryRepository.findByName("History").get(0));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test 
	public void deleteBook() {
		List<Book> books = bookRepository.findByTitle("Seitsemän sisarta");
		bookRepository.deleteById(books.get(0).getId());
		books= bookRepository.findByTitle("Seitsemän sisarta");
		assertThat(books).hasSize(0);
	}
}
