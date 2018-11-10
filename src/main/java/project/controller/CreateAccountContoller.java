package project.controller;



import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.model.Calendar;
import project.model.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;
import project.service.Implementation.UserServiceImplementation;

@Controller
public class CreateAccountContoller {
	
	@RequestMapping(value = "/createaccount", method = RequestMethod.GET)
	public String createAccount(Model model) {
		
		model.addAttribute("user", new User());
		
		return "CreateAccount";
	}
	
	@RequestMapping(value = "/accountcreated", method = RequestMethod.POST)
	public String accountCreated(@ModelAttribute("user") User user, Model model) {
		
		Long id = user.getId();
		//UserService userService = new UserServiceImplementation(new JpaRepository<User, id>());

		UserService userService = new UserServiceImplementation();
		user.setCalendar(new Calendar());
		user.setFriends(new HashSet<User>());
		
		userService.save(user);
		
		
		model.addAttribute("user", new User());
		
		return "AccountCreated";
		
	}
	

	
  
}
