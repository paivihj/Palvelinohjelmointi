package fi.pju.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.pju.Bookstore.domain.Book;
import fi.pju.Bookstore.domain.BookRepository;
import fi.pju.Bookstore.domain.Category;
import fi.pju.Bookstore.domain.CategoryRepository;

@RestController
public class BookRestController {
	
	@Autowired 
	BookRepository brepo;
	
	@Autowired
	CategoryRepository crepo;

	@RequestMapping("/books")
	public List <Book>bookListRest() {
		return (List<Book>) brepo.findAll();
	}
	
	@RequestMapping("/book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return brepo.findById(id);
	}
	
	@RequestMapping("/categories")
	public List <Category>catListRest() {
		return (List<Category>) crepo.findAll();
	}
}
