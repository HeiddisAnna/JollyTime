package project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addThisFriend(@RequestParam(value = "email") String email, Model model, HttpSession session) {
		
		JollyUser user = (JollyUser) session.getAttribute("user");

		// Tékka ef email er til
		if (userService.findByEmail(email) == null) {
			model.addAttribute("errormessage", "Þetta netfang hefur ekki aðgang");
			return "AddFriend";
		// Annars tékka hvort email sé þegar vinur
		} else if (user.isUserAFriend(email)) {
			model.addAttribute("errormessage", "Þið eruð nú þegar vinir");
			return "AddFriend";
		// Hleypa í gegn
		} else {
			user.addFriend(userService.findByEmail(email));
			userService.save(user);
			return "Calendar";
		}
		
	}
	
	@RequestMapping(value = "/cancelFriend", method = RequestMethod.GET)
	public String cancelFriend() {
		return "Calendar";
	}

}
