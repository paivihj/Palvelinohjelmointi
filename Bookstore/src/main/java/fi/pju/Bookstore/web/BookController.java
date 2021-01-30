package fi.pju.Bookstore.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.pju.Bookstore.domain.Book;

public class BookController {
	
	@RequestMapping("/index")
	public String helloPerson(@RequestParam(name="book") Book book, Model model) {
		
		model.addAttribute("book", book);
	
		return "index";
	}
}