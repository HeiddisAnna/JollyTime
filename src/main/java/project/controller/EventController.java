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
    	
    	String[] times = {"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30",
    			"06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00",
    			"12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30",
    			"19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};

    	model.addAttribute("startYear", new String());
    	model.addAttribute("startMonth", new String());
    	model.addAttribute("startDay", new String());
    	model.addAttribute("startTime", new String());
    	model.addAttribute("description", new String());
    	model.addAttribute("title", new String());
    	
    	model.addAttribute("endYear", new String());
    	model.addAttribute("endMonth", new String());
    	model.addAttribute("endDay", new String());
    	model.addAttribute("endTime", new String());
    	
    	model.addAttribute("startYears",  years);
    	model.addAttribute("startMonths",  months);
    	model.addAttribute("startDays",  days);
    	model.addAttribute("startTimes", times);
    	
    	model.addAttribute("endYears",  years);
    	model.addAttribute("endMonths",  months);
    	model.addAttribute("endDays",  days);
    	model.addAttribute("endTimes", times);
    	
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
