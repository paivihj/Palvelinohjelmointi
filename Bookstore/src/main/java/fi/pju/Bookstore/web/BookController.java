package fi.pju.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.pju.Bookstore.domain.Book;
import fi.pju.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/booklist")
	public String books(Model model) {
		
		model.addAttribute("books", repository.findAll());
	
		return "booklist";
	}
	
	@GetMapping("/addbook")
	public String newBook(Model model) {
		
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping("save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Optional<Book> book = repository.findById(bookId);
		model.addAttribute("book", book);
		return "editbook";
	}
	
	@PostMapping("/update/{id}")
	public String saveEditedBook(@PathVariable("id") Long bookId, Book book) {
		repository.save(book);
		return "redirect:../booklist";
	}
	
}