package project;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

import project.model.Event;
import project.model.JollyUser;
import project.service.EventService;

public class Util {

	public static Calendar calendar = Calendar.getInstance();
	
	public static class Year {
		public int year;
		public ArrayList<ArrayList<Day>> months;

		public Year(int year, ArrayList<ArrayList<Day>> months) {
			this.year = year;
			this.months = months;
		}
	}
	
	public static class Day {
		public int month;
		public String monthName;
		public int day;
		public String dayName;
		public boolean isToday;
		public String description;
		
		public Day(int month, String monthName, int day, String dayName, ArrayList<Event> events) {
			this.month = month;
			this.monthName = monthName;
			this.day = day;
			this.dayName = dayName;
			this.isToday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == day;
			
			String descr = "";
			for (int i = 0; i < events.size(); i++) {
				descr += events.get(i).title;
				if (i + 1 < events.size()) {
					descr += "\n";
				}
			}
			this.description = descr;
		}
	}
	
	static HashMap<Integer, String> getDayNames() {
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(Calendar.SUNDAY, "Sunday");
		hm.put(Calendar.MONDAY, "Monday");
		hm.put(Calendar.TUESDAY, "Tuesday");
		hm.put(Calendar.WEDNESDAY, "Wednesday");
		hm.put(Calendar.THURSDAY, "Thursday");
		hm.put(Calendar.FRIDAY, "Friday");
		hm.put(Calendar.SATURDAY, "Saturday");
		
		return hm;
		
	}
	
	public static HashMap<Integer, String> getMonthNames() {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(Calendar.JANUARY, "January");
		hm.put(Calendar.FEBRUARY, "February");
		hm.put(Calendar.MARCH, "March");
		hm.put(Calendar.APRIL, "April");
		hm.put(Calendar.MAY, "May");
		hm.put(Calendar.JUNE, "June");
		hm.put(Calendar.JULY, "July");
		hm.put(Calendar.AUGUST, "August");
		hm.put(Calendar.SEPTEMBER, "September");
		hm.put(Calendar.OCTOBER, "October");
		hm.put(Calendar.NOVEMBER, "November");
		hm.put(Calendar.DECEMBER, "December");
		
		return hm;
	}

	/*public static ArrayList<Day> getMonth(int month) {
		ArrayList<Day> list = new ArrayList<Day>();
		
	    calendar.set(Calendar.MONTH, month);
	    // calendar.set(Calendar.DAY_OF_MONTH, 1);
	    int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	    
	    for (int i = 0; i < maxDay; i++) {
	    	calendar.set(Calendar.DAY_OF_MONTH,  i + 1);
	    	String dayName = getDayNames().get(calendar.get(Calendar.DAY_OF_WEEK));
	    	Util.Day day = new Util.Day(calendar.get(Calendar.DAY_OF_MONTH), dayName);
	    	list.add(day);
	    }
		
		return list;
	}*/
	
	public static ArrayList<Day> getMonth(int month, int year, EventService service) {
		ArrayList<Day> list = new ArrayList<Day>();
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		int maxMonth = calendar.getActualMaximum(Calendar.MONTH);
		int maxDay = calendar.getActualMaximum((Calendar.DAY_OF_MONTH));

		String monthName = getMonthNames().get(calendar.get(Calendar.MONTH));
		
		List<Event> events = service.getAllEventsInMonth(year, month);

		for (int i = 0; i < maxDay; i++) {
			int dayInt = i + 1;
			calendar.set(Calendar.DAY_OF_MONTH, dayInt);
	    	String dayName = getDayNames().get(calendar.get(Calendar.DAY_OF_WEEK));
	    		    	
	    	ArrayList<Event> eventsForDay = new ArrayList<Event>();
	    	for (int j = 0; j < events.size(); j++) {
	    		Event event = events.get(j);
	    		if (event.getDays(month, year).contains(dayInt)) {
	    			eventsForDay.add(event);
	    		}
	    	}
	    	
	    	Util.Day day = new Util.Day(calendar.get(Calendar.MONTH), monthName, calendar.get(Calendar.DAY_OF_MONTH),dayName, eventsForDay);
	    	list.add(day);
		}

		return list;
	}
	
	public static int getWeekday(int year, int month) {
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		int extraDivs = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		
		return extraDivs;
	}
	
	public static void addNecessaryAttributesForCalendar(Optional<Integer> month, Optional<Integer> year, JollyUser user, Model model, EventService service) {
		model.addAttribute("name", user.getName());
		model.addAttribute("friends", user.getFriends());
		model.addAttribute("email", user.getEmail());

		int yearInt = Calendar.getInstance().get(Calendar.YEAR);
		int monthInt = Calendar.getInstance().get(Calendar.MONTH);
		int dayInt = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		if (year.isPresent()) {
			yearInt = year.get();
		}
		
		if (month.isPresent()) {
			monthInt = month.get();
		}
		
		int selectedYear = yearInt;
		int selectedMonth = monthInt;
		
		int nextYear = selectedYear;
        int nextMonth = selectedMonth + 1;
        if (nextMonth > 11) {
        	nextYear += 1;
        	nextMonth = nextMonth % 12;
        }
        
        int prevYear = selectedYear;
        int prevMonth = selectedMonth - 1;
        
        if (prevMonth < 0) {
        	prevYear -= 1;
        	prevMonth = 11;
        }
        
        model.addAttribute("eventsInMonth", service.getAllEventsInMonth(yearInt, monthInt));
        model.addAttribute("extraDivsWeekdays", getWeekday(yearInt, monthInt));
        model.addAttribute("nextYear", nextYear);
        model.addAttribute("nextMonth", nextMonth);
        model.addAttribute("prevYear", prevYear);
        model.addAttribute("prevMonth", prevMonth);
        model.addAttribute("selectedDay", dayInt);
        model.addAttribute("selectedMonth", monthInt);
		model.addAttribute("selectedYear", yearInt);
		model.addAttribute("days", getMonth(Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR), service));
		model.addAttribute("month", getMonth(monthInt, yearInt, service));
		model.addAttribute("monthNames", getMonthNames());
		model.addAttribute("email", user.getEmail());
	}
	
}

/*cal.set(Calendar.MONTH, 1);
cal.set(Calendar.DAY_OF_MONTH, 1);
int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
System.out.print(df.format(cal.getTime()));
for (int i = 1; i < maxDay; i++) {
    cal.set(Calendar.DAY_OF_MONTH, i + 1);
    System.out.print(", " + df.format(cal.getTime()));
}*/