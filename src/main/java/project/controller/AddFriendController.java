package project.controller;

import java.util.Calendar;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.Util;
import project.model.JollyUser;
import project.service.EventService;
import project.service.UserService;


@Controller
public class AddFriendController {
	
	UserService userService;
	EventService eventService;
	
	@Autowired
	public AddFriendController(UserService userService, EventService eventService) {
		this.userService = userService;
		this.eventService = eventService;
	}

	@RequestMapping(value = "/addFriend", method = RequestMethod.GET)
	public String addFriend() {
		return "AddFriend";
	}
	
	@RequestMapping(value = "/addThisFriend", method = RequestMethod.POST)
	public String addThisFriend(@RequestParam(value = "email") String email, Model model, HttpSession session, 
			@RequestParam Optional<Integer> month, @RequestParam Optional<Integer> year) {
		
		JollyUser user = (JollyUser) session.getAttribute("user");
		JollyUser friend = userService.findByEmail(email);

		// Tékka ef email er til
		if (friend == null) {
			model.addAttribute("errormessage", "This email does not have an account");
			return "AddFriend";
		// Ef user og vinur er sá sami
		} else if (user.getEmail().equals(email)) {
			model.addAttribute("errormessage", "You can't be your own friend, sorry");
			return "AddFriend";
		// Annars tékka hvort email sé þegar vinur
		} else if (user.isUserAFriend(email)) {
			model.addAttribute("errormessage", "You are already friends");
			return "AddFriend";
		// Hleypa í gegn
		} else {
			
			
			
			user.addFriend(friend);
			friend.addFriend(user);
			
			userService.save(user);
			userService.save(friend);
			
			Util.addNecessaryAttributesForCalendar(Optional.empty(), Optional.empty(), user, model, eventService);
			
			return "Calendar";
		}
		
	}
	


}
