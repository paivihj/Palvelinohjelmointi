package fi.pju.Week2E1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String helloPerson(@RequestParam(name="age") int age, 
							@RequestParam(name="name") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
	
		return "hello";
	}

}