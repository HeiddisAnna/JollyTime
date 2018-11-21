package project.controller;



import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.model.Calendar;
import project.model.JollyUser;
import project.persistence.repositories.UserRepository;
import project.service.UserService;
import project.service.Implementation.UserServiceImplementation;

@Controller
public class CreateAccountController {
	UserService userService;
	
	@Autowired
	public CreateAccountController(UserService userService) {
		this.userService = userService;
	}
	
	//value er það sem bærtist við urlið þegar þú gerir þetta. 
	// Þú getur annað hvort verið með post eða get, get er til að sækja upplýsingar, notar get til að fara yfir á næstu síðu
	// Hann skilar jsp filnum til að fara á þá síðu
	@RequestMapping(value = "/createaccount", method = RequestMethod.GET) 
	public String createAccount(Model model) {
		
		model.addAttribute("user", new JollyUser()); //hann verður að setja inn user til að fara á þessa síðu
		
		return "CreateAccount";
	}
	
	
	@RequestMapping(value = "/accountcreated", method = RequestMethod.POST)
	public String accountCreated(@ModelAttribute("user") JollyUser user, Model model) {
		
		userService.save(user);
		
		model.addAttribute("user", new JollyUser());
		
		return "AccountCreated";
	}
	
	
	

	
  
}
