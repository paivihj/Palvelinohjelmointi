package fi.pju.Week2E3.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Friend;

@Controller
public class FriendController {
	
	ArrayList<Friend> friendList = new ArrayList<>();
	
	@PostMapping("/index")
	public String newFriend(@ModelAttribute Friend frendi, Model model) {
		
		friendList.add(frendi);
		
		model.addAttribute("friends", friendList);
		return "index";
	}
	
	@GetMapping("/index")
	public String showFriends(Model model) {
		
		model.addAttribute("friend", new Friend());
		return "index";
	}
}
