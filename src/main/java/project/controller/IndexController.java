package project.controller;

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
	public String home(/*Model model*/) {
		
		return "IndexForm";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public String backHome() {
		return "IndexForm";
	}
	
	
	@RequestMapping(value = "/calendar", method = RequestMethod.POST)
	public String logIn(Model model) {
		String email = "jdklaj"; // Hvernig sæki ég rétt email
		User user = userService.findByEmail(email);
		
		//Ef notandinn er ekki til þarf hann að logga sig inn 
		if(user == null) {
			//Byrta skilaboð um að notandi sé ekki til
			//Hverju á ég þá að returna ??
			return "Calendar";
		} 
		return "Calendar";
	}
}
