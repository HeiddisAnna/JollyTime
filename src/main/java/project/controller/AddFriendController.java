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

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
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
	
	@RequestMapping(value = "/addThisFriend", method = RequestMethod.GET)
	public String addThisFriend(@RequestParam(value = "email") String email, Model model, HttpSession session) {
		JollyUser user = (JollyUser) session.getAttribute("user");
		
/*
		if (userService.findByEmail(email) == null) {
			model.addAttribute("errormessage", "Þetta netfang hefur ekki aðgang");
			return "AddFriend";
		} else if (!(user.getId() == userService.doesIDMatchFriend(user.getId(), userService.findByEmail(email).getId()))) {
			model.addAttribute("errormessage", "Þið eruð nú þegar vinir");
			return "AddFriend";
		}
		else return "Calendar";
		
		*/
		
		return "Calendar";
	}
	


}
