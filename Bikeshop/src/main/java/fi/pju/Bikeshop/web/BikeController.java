package fi.pju.Bikeshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.pju.Bikeshop.domain.Bike;
import fi.pju.Bikeshop.domain.BikeRepository;
import fi.pju.Bikeshop.domain.SingleBike;
import fi.pju.Bikeshop.domain.SingleBikeRepository;

@Controller
public class BikeController {
	@Autowired 
	private BikeRepository bikeRepo;
	
	@Autowired
	private SingleBikeRepository sBikeRepo;
	
	@RequestMapping("/bikeshop")
	public String bikes(Model model) {
		
		model.addAttribute("bikes", bikeRepo.findAll());
		model.addAttribute("singleBikes", sBikeRepo.findAll());
	
		return "bikeshop";
	}
	
	@GetMapping("/addbike")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String newBike(Model model) {
		
		model.addAttribute("bike", new Bike());
		return "addbike";
	}
	
	@PostMapping("save")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveBike(Bike bike) {
		bikeRepo.save(bike);
		return "redirect:bikeshop";
	}
	
	@GetMapping("/addbikes")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addBikes(Model model) {
		
		model.addAttribute("bikes", bikeRepo.findAll());
		model.addAttribute("singleBike", new SingleBike());
		
		return "addbikes";
	}
	
	@PostMapping("saveBike")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveBikes(SingleBike singleBike) {

		sBikeRepo.save(singleBike);
		
		return "redirect:bikeshop";
	}
	
}
