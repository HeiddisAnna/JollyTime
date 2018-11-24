package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.model.Event;
import project.model.JollyUser;
import project.service.EventService;
import project.service.UserService;


@Controller
public class EventController {


	EventService eventService;
	
	@Autowired
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	

    @RequestMapping(value = "/addEvent", method = RequestMethod.GET)
    public String addEvent(Model model){
    	
    	int[] years = {2018, 2019, 2020};
    	String[] months = {"Janúar", "Febrúar", "Mars", "Apríl", 
    						"Maí", "Júní", "Júlí", "Ágúst", 
    						"September", "Október", "Nóvember", "Desember"};
    	
    	int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
    			11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
    			21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    	
    	
    	
    	model.addAttribute("startYear", new String());
    	model.addAttribute("startMonth", new String());
    	model.addAttribute("startDay", new String());
    	
    	model.addAttribute("endYear", new String());
    	model.addAttribute("endMonth", new String());
    	model.addAttribute("endDay", new String());
    	
    	model.addAttribute("startYears",  years);
    	model.addAttribute("startMonths",  months);
    	model.addAttribute("startDays",  days);
    	
    	model.addAttribute("endYears",  years);
    	model.addAttribute("endMonths",  months);
    	model.addAttribute("endDays",  days);
    	
    	model.addAttribute("event", new Event());
        return "CreateEvent"; 
    }
    
    @RequestMapping(value = "/bla", method = RequestMethod.POST)
    public String bla() {
    	return "Test";
    }
    
    @RequestMapping(value = "/bla1", method = RequestMethod.POST)
    public String bla1() {
    	return "Test";
    }
    
	@RequestMapping(value = "/eventcreated", method = RequestMethod.POST)
	public String accountCreated(@ModelAttribute("event") Event event, Model model) {
		
		// Tékka hvort sé fyllt inn í title, start date og end date 
		
		
		
		eventService.save(event);
		
		return "Calendar";
	}
    


}
