package fi.pju.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.pju.Bookstore.domain.Book;
import fi.pju.Bookstore.domain.BookRepository;
import fi.pju.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@RequestMapping("/booklist")
	public String books(Model model) {
		
		model.addAttribute("books", repository.findAll());
	
		return "booklist";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/addbook")
	public String newBook(Model model) {
		
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepository.findAll());
		return "addbook";
	}
	
	@PostMapping("save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Book book = repository.findById(bookId).get();
		model.addAttribute("book", book);
		model.addAttribute("categories", catRepository.findAll());
		return "editbook";
	}
	
}