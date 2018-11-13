package project.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.model.User;
import project.service.UserService;
import project.service.Implementation.UserServiceImplementation;

@Controller
public class IndexController {
	
	UserService userService;
	
	@Autowired
	public IndexController(UserService userService) {
	this.userService = userService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "IndexForm";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public String backHome(Model model) {
		model.addAttribute("user", new User());

		return "IndexForm";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logIn(@ModelAttribute User user ,HttpSession session, Model model) {
				
		if (user != null) {
			session.setAttribute("user", user);
			model.addAttribute("user", new User());
			model.addAttribute("nom", user.getName());
			return "IndexResult";
		} else {
			return "IndexForm";
		}
		
	}
}
