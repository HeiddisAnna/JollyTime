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

import project.model.JollyUser;
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
		model.addAttribute("user", new JollyUser());
		return "IndexForm";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public String backHome(Model model) {
		model.addAttribute("user", new JollyUser());

		return "IndexForm";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String logIn(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password, Model model, HttpSession session) {
		JollyUser user = userService.findByEmail(email);
		
		//Ef notandinn er ekki til þarf hann að logga sig inn 
		if(user == null || !(user.getPassword().equals(password))) {
			model.addAttribute("errormessage", "Vitlaust netfang eða lykilorð");
			return "IndexForm";
		}
		session.setAttribute("user",  user);
		model.addAttribute("name", user.getName());
		
		return "Calendar";
	}
}
