package project.controller;



import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.Util;
import project.model.JollyUser;
import project.persistence.repositories.UserRepository;
import project.service.UserService;
import project.service.Implementation.UserServiceImplementation;

@Controller
public class CalendarController {
	UserService userService;
	
	@Autowired
	public CalendarController(UserService userService) {
		this.userService = userService;
	}
	

	
	
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String goToNextMonth(Model model, HttpSession session, @RequestParam Optional<Integer> month, @RequestParam Optional<Integer> year) {

		JollyUser user = (JollyUser) session.getAttribute("user");
		
		Util.addNecessaryAttributesForCalendar(month, year, user, model);
		
		return "Calendar";
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancelEvent(HttpSession session, Model model, @RequestParam Optional<Integer> month, @RequestParam Optional<Integer> year) {
		
		JollyUser user = (JollyUser) session.getAttribute("user");
		
		Util.addNecessaryAttributesForCalendar(month, year, user, model);
		
		return "Calendar";
	}
	
	@RequestMapping(value = "/logOut")
	public String logOut(Model model, HttpSession session) {
		session.removeAttribute("user");
		return "IndexForm";
	}
	
	

	
  
}
