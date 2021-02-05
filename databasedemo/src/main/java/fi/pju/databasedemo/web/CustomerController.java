package fi.pju.databasedemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.pju.databasedemo.domain.CustomerRepository;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping(value="/customers")
	public String studentList(Model model) {
		model.addAttribute("customers", repository.findAll());
		return "customers";
	}

}
