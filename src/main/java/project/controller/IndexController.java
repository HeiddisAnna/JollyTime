package project.controller;

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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(/*Model model*/) {
		
		return "IndexForm";
	}
	
	@RequestMapping(params="login", method=RequestMethod.POST)
	public String login() {
		return "/IndexResult";
	}
	
	

}
