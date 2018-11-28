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
import project.service.UserService;


@Controller
public class AddFriendController {
	
	UserService userService;
	
	@Autowired
	public AddFriendController(UserService userService) {
		this.userService = userService;
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
			model.addAttribute("errormessage", "Þetta netfang hefur ekki aðgang");
			return "AddFriend";
		// Ef user og vinur er sá sami
		} else if (user.getEmail().equals(email)) {
			model.addAttribute("errormessage", "Þú getur ekki verið vinur þinn");
			return "AddFriend";
		// Annars tékka hvort email sé þegar vinur
		} else if (user.isUserAFriend(email)) {
			model.addAttribute("errormessage", "Þið eruð nú þegar vinir");
			return "AddFriend";
		// Hleypa í gegn
		} else {
			
			
			
			user.addFriend(friend);
			friend.addFriend(user);
			
			userService.save(user);
			userService.save(friend);
			
			Util.addNecessaryAttributesForCalendar(Optional.empty(), Optional.empty(), user, model);
			
			return "Calendar";
		}
		
	}
	


}
