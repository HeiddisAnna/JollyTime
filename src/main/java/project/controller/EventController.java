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
    	model.addAttribute("event", new Event());
        return "CreateEvent"; 
    }
    
	@RequestMapping(value = "/eventcreated", method = RequestMethod.POST)
	public String accountCreated(@ModelAttribute("event") Event event, Model model) {
		
		eventService.save(event);
		
		return "Calendar";
	}
    


}
