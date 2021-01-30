package fi.pju.Week2E2.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.pju.Week2E2.domain.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/studentlist")
	public String showStudents(Model model) {
		ArrayList<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("Pete", "Puuha"));
		
		Student student = new Student();
		student.setFirstName("Tapio");
		student.setLastName("Rinne");
		studentList.add(student);
		
		student = new Student("Elizabeth", "Taylor");
		studentList.add(student);
		
		model.addAttribute("students", studentList);
	
		return "studentlist";
	}

}
