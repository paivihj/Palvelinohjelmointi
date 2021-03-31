package fi.pju.Bikeshop.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fi.pju.Bikeshop.domain.Bike;
import fi.pju.Bikeshop.domain.BikeRepository;
import fi.pju.Bikeshop.domain.Customer;
import fi.pju.Bikeshop.domain.CustomerRepository;
import fi.pju.Bikeshop.domain.Order;
import fi.pju.Bikeshop.domain.OrderList;
import fi.pju.Bikeshop.domain.OrderRepository;
import fi.pju.Bikeshop.domain.OrderRow;
import fi.pju.Bikeshop.domain.OrderRowRepository;
import fi.pju.Bikeshop.domain.SingleBike;
import fi.pju.Bikeshop.domain.SingleBikeRepository;

@Controller
@SessionAttributes("orderAttribute")
public class OrderController {
	
	@Autowired 
	private BikeRepository bikeRepo;
	
	@Autowired
	private SingleBikeRepository sBikeRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired 
	private OrderRowRepository rowRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@GetMapping("/customerinfo")
	public String customerInfo(Model model) {
		
		model.addAttribute("newCustomer", new Customer());
		
		return "customerinfo";
	}
	
	@PostMapping("saveCustomer")
	public String saveCustomer(Customer customer) {
		custRepo.save(customer);
		Order order = new Order(0, LocalDate.now(), customer);
		orderRepo.save(order);
		return "redirect:order/" + order.getId();
	}
	
	@ModelAttribute("orderAttribute")
	public OrderList orderAttribute() {
		return new OrderList();
	}
	
	@GetMapping("/order/{order_id}")
	public String getBikes(Model model, @PathVariable("order_id") Long orderId) {
		
		System.out.println(orderId);
		
		Order order = orderRepo.findById(orderId).get();
		model.addAttribute("thisOrder", order);
		
		System.out.println(order.toString());
		
		OrderRow row = new OrderRow();
		row.setOrder(order);
		
		model.addAttribute("singleBikes", sBikeRepo.findFree());
		model.addAttribute("orderRow", row);
		
		return "order";
	}
	
	@PostMapping("saveOrder")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public String saveOrderRow(OrderRow orderrow) {
		rowRepo.save(orderrow);
		return "redirect:bikeshop";
	}

}
