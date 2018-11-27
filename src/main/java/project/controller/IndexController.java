package project.controller;

import java.util.Calendar;
import java.util.Optional;

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
import project.Util;
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
	
	@RequestMapping(value = "/calendar", method = RequestMethod.POST)
	public String logIn(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password, @RequestParam Optional<Integer> month, @RequestParam Optional<Integer> year, Model model, HttpSession session) {

		JollyUser user = userService.findByEmail(email);
		
		//Ef notandinn er ekki til þarf hann að logga sig inn 
		if(user == null || !(user.getPassword().equals(password))) {
			model.addAttribute("errormessage", "Vitlaust netfang eða lykilorð");
			return "IndexForm";
		}
		session.setAttribute("user",  user);
		model.addAttribute("name", user.getName());
		int yearInt = -1;
		int monthInt = -1;
		if (year.isPresent()) {
			yearInt = year.get();
		} else {
			yearInt = Calendar.getInstance().get(Calendar.YEAR);
		}
		
		if (month.isPresent()) {
			model.addAttribute("selectedMonth", month.get());
		} else {
			model.addAttribute("selectedMonth", Calendar.getInstance().get(Calendar.MONTH));
			
		}
		
		model.addAttribute("selectedMonth", monthInt);
		model.addAttribute("selectedYear", yearInt);
		model.addAttribute("month", Util.getMonth(monthInt, yearInt));
		model.addAttribute("monthNames", Util.getMonthNames());
		model.addAttribute("email", user.getEmail());
		return "Calendar";
	}
	
	@RequestMapping(value = "/seeFriends", method = RequestMethod.GET) 
	public String seeFriends(Model model, HttpSession session) {
		
		JollyUser user = (JollyUser) session.getAttribute("user");
		
		model.addAttribute("friends", user.getFriends());
		
		return "Test2";
		
	}
	
	@RequestMapping(value = "/logOut", method = RequestMethod.GET) 
	public String seeFriends(HttpSession session) {
		session.removeAttribute("user");
		return "IndexForm";
		
	}
	
}
