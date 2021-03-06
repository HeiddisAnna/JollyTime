package project.controller;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.lang.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.Util;
import project.model.Event;
import project.model.JollyUser;
import project.service.EventService;
import project.service.UserService;


@Controller
public class FindDateController {

    EventService eventService;
	UserService userService;
	
	@Autowired
	public FindDateController(EventService eventService, UserService userService) {
		this.eventService = eventService;
		this.userService = userService;
	}
	

    @RequestMapping(value = "/bookDate", method = RequestMethod.GET)
    public String addEvent(Model model, HttpSession session){
    	
    	String[] years = {"2018", "2019", "2020"};
    	String[] months = {"January", "February", "March", "April", 
    						"May", "June", "July", "August", 
    						"September", "Oktober", "November", "December"};
    	
    	String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
    			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
    			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    	
    	String[] times = {"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30",
    			"06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00",
    			"12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30",
    			"19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
    	
    	String[] length = {"30 min", "1 hour", "1.5 hour", "2 hours", "2.5 hours", "3 hours", "3.5 hours", "4 hours",
    			"4.5 hours", "5 hours", "6 hours", "7 hours"};
  
    	
    	JollyUser user = (JollyUser)session.getAttribute("user");
    	model.addAttribute("friends", user.getFriends());
    	

    	model.addAttribute("startYear", new String());
    	model.addAttribute("startMonth", new String());
    	model.addAttribute("startDay", new String());
    	model.addAttribute("startTime", new String());
    	
    	model.addAttribute("endYear", new String());
    	model.addAttribute("endMonth", new String());
    	model.addAttribute("endDay", new String());
    	model.addAttribute("endTime", new String());
    	
    	model.addAttribute("dateLength", new String());
    	
    	model.addAttribute("description", new String());
    	model.addAttribute("title", new String());
    	
    	model.addAttribute("startYears",  years);
    	model.addAttribute("startMonths",  months);
    	model.addAttribute("startDays",  days);
    	model.addAttribute("startTimes", times);
    	
    	model.addAttribute("endYears",  years);
    	model.addAttribute("endMonths",  months);
    	model.addAttribute("endDays",  days);
    	model.addAttribute("endTimes", times);
    	
    	model.addAttribute("dateLengths", length);
    	
    	model.addAttribute("event", new Event());
        return "FindDate"; 
    }
    

    
	@RequestMapping(value = "/bookThisDate", method = RequestMethod.POST)
	public String accountCreated(@RequestParam(value = "title") String title, @RequestParam(value = "description") String description,
			@RequestParam(value = "startYear") String startYear, @RequestParam(value = "startMonth") String startMonth, 
			@RequestParam(value = "startDay") String startDay, //@RequestParam(value = "startTime") String startTime,
			@RequestParam(value = "endYear") String endYear, @RequestParam(value = "endMonth") String endMonth, 
			@RequestParam(value = "endDay") String endDay, //@RequestParam(value = "endTime") String endTime, 
			@RequestParam(value = "selectedFriends") Set<String> selectedFriends, @RequestParam(value = "dateLength") String dateLength,
			Model model, HttpSession session, @RequestParam Optional<Integer> month, @RequestParam Optional<Integer> year) {
		
		JollyUser user = (JollyUser)session.getAttribute("user");
		Set<JollyUser> users = new HashSet<JollyUser>();
		users.add(user);
		
		Set<JollyUser> friends = new HashSet<JollyUser>();
		

		Iterator<String> friendIterator =  selectedFriends.iterator();
		while(friendIterator.hasNext()) {
			JollyUser friendUser = userService.findByEmail(friendIterator.next());
			users.add(friendUser);
			friends.add(friendUser);
		}
			
		int startMonthNumber = findMonthNumber(startMonth);
		int endMonthNumber = findMonthNumber(endMonth);
		// Tékka hvort sé fyllt inn í title, start date og end date 
		if (checkForData(title, startYear, startMonth, startDay, endYear, endMonth, endDay) == false) {
			model.addAttribute("errormessage", "Please fill in title, start time and end time");
			return "CreateEvent";
		} else if (checkForTime(startYear, startMonthNumber, startDay,  endYear, endMonthNumber, endDay) == false) {
			model.addAttribute("errormessage", "Please, make sure start date occurs before end date");
			return "CreateEvent";
		}

		
		Calendar startDate = Calendar.getInstance();
		startDate.set(Integer.parseInt(startYear), startMonthNumber, Integer.parseInt(startDay), 0, 0);
		
		Calendar endDate = Calendar.getInstance();
		endDate.set(Integer.parseInt(endYear), endMonthNumber, Integer.parseInt(endDay), 23, 59);

		Event event = new Event(title, description, startDate, endDate, users);
		
		Set<Event> events = new HashSet<Event>();
		events.add(event);
		
		Long newDateLength = findDateLength(dateLength);
		
		Set<Event> finalEvents = findDateAlgo(events, users, newDateLength, model);
		

		
		model.addAttribute("name", user.getName());
		model.addAttribute("selectedFriends", friends);
		model.addAttribute("events", finalEvents);
		
		return "SuggestedDates";
	}
	
	// Fyrir Andra: Byrjaði en komst eins og þú sérð ekki mjög langt.
	// Hefðum samt örugglega lent í sömu vandræðum því iteratorinn var ekki að virka hjá okkur
	public ArrayList<Integer> findDateAlgo2(Set<JollyUser> users, Long dateLength, Event event) {
		int dl = (int) (24 * Math.ceil(dateLength/60));
		Boolean[] listOfPossibleDates = new Boolean[dl];
		Iterator<JollyUser> usersIterator = users.iterator();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (usersIterator.hasNext()) {
			JollyUser user = usersIterator.next();
			Iterator<Event> userEventIterator = user.getEvents().iterator();
			while (userEventIterator.hasNext()) {
				Event userEvent = userEventIterator.next();
				// ef userEvent byrjar eftir að event hefst
				if (event.startsBefore(userEvent)) {
					// komst ekki lengra :( 
				}
	
			}
		}
		return list;
		
	}
	
	public Set<Event> findDateAlgo(Set<Event> events, Set<JollyUser> users, Long dateLength, Model model){
		Iterator<Event> eventIterator = events.iterator();
		Iterator<JollyUser> usersIterator = users.iterator();
		if (users.isEmpty()) model.addAttribute("errormessage", "piss");
		
		while(usersIterator.hasNext()) {
			
			JollyUser user = usersIterator.next();
			if(user == null) { model.addAttribute("errormessage", "User not found"); }
			else if (!user.getEvents().isEmpty()) { 
				Iterator<Event> userEventIterator = user.getEvents().iterator();
				while(userEventIterator.hasNext()) {
					Event userEvent = userEventIterator.next();
					while(eventIterator.hasNext()) {
						Event event = eventIterator.next();
						if(event.getLength() < dateLength) {
							events.remove(event);
						} else {
							if(userEvent.startsBefore(event) && event.endsAfter(userEvent)) {
								Event newEvent = new Event(event.getTitle(), event.getDescription(), userEvent.getEndDate(), event.getEndDate(), users);
								events.add(newEvent);
							} else {
								if(event.startsBefore(userEvent) && event.endsAfter(userEvent)) {
									Event firstNewEvent = new Event(event.getTitle(), event.getDescription(), event.getStartDate(), userEvent.getEndDate(), users);
									Event secondNewEvent = new Event(event.getTitle(), event.getDescription(), userEvent.getEndDate(), event.getEndDate(), users);
									events.add(firstNewEvent);
									events.add(secondNewEvent);
								} else {
									if(event.startsBefore(userEvent) && userEvent.endsAfter(event)) {
										Event newEvent = new Event(event.getTitle(), event.getDescription(), event.getStartDate(), userEvent.getStartDate(), users);
										events.add(newEvent);
									}
								}
							}
							events.remove(event);	
						}
					}
				} 
			}
		}
		return events;
	}
	
	
	public int findMonthNumber(String month) {
		if (month.equals("January")) {
			return 0;
		} else if (month.equals("February")) {
			return 1;
		} else if (month.equals("March")) {
			return 2;
		} else if (month.equals("April")) {
			return 3;
		} else if (month.equals("May")) {
			return 4;
		} else if (month.equals("June")) {
			return 5;
		} else if (month.equals("July")) {
			return 6;
		} else if (month.equals("August")) {
			return 7;
		} else if (month.equals("September")) {
			return 8;
		} else if (month.equals("Oktober")) {
			return 9;
		} else if (month.equals("November")) {
			return 10;
		} else return 11;
	}
	
	
	public Long findDateLength(String dateLength) {
		if (dateLength.equals("30 min")) {
			return new Long(30);
		} else if (dateLength.equals("1 hour")) {
			return new Long(60);
		} else if (dateLength.equals("1.5 hour")) {
			return new Long(90);
		} else if (dateLength.equals("2 hours")) {
			return new Long(120);
		} else if (dateLength.equals("2.5 hours")) {
			return new Long(150);
		} else if (dateLength.equals("3 hours")) {
			return new Long(180);
		} else if (dateLength.equals("3.5 hours")) {
			return new Long(210);
		} else if (dateLength.equals("4 hours")) {
			return new Long(240);
		} else if (dateLength.equals("4.5 hours")) {
			return new Long(270);
		} else if (dateLength.equals("5 hours")) {
			return new Long(300);
		} else if (dateLength.equals("6 hours")) {
			return new Long(360);
		} else return new Long(420);
	}
	
	
	public Boolean checkForTime(String startYear, int startMonthNumber, String startDay, 
			String endYear, int endMonthNumber, String endDay) {
		

		if (Integer.parseInt(startYear) > Integer.parseInt(endYear)) {
			return false;
		} else if (Integer.parseInt(startYear) == Integer.parseInt(endYear) && startMonthNumber > endMonthNumber) {
			return false;
		} else if (Integer.parseInt(startYear) == Integer.parseInt(endYear) && startMonthNumber > endMonthNumber
				&& Integer.parseInt(startDay) > Integer.parseInt(endDay)) {
			return false;
		
		}
		return true;
	}
	
	public Boolean checkForData(String title, String startYear, String startMonth, String startDay, 
			String endYear, String endMonth, String endDay) {
		
		if (title == null || startYear.equals("- - - Select - - -") || startMonth.equals("- - - Select - - -") || startDay.equals("- - - Select - - -") || 
				endYear.equals("- - - Select - - -") || endMonth.equals("- - - Select - - -") || 
				endDay.equals("- - - Select - - -") ) {
			return false;
		}
		return true;
		
	}
	


}
