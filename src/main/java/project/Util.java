package project;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

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
		
		public Day(int month, String monthName, int day, String dayName) {
			this.month = month;
			this.monthName = monthName;
			this.day = day;
			this.dayName = dayName;
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
	
	public static ArrayList<Day> getMonth(int month, int year) {
		ArrayList<Day> list = new ArrayList<Day>();
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		int maxMonth = calendar.getActualMaximum(Calendar.MONTH);
		int maxDay = calendar.getActualMaximum((Calendar.DAY_OF_MONTH));

		String monthName = getMonthNames().get(calendar.get(Calendar.MONTH));
	
		for (int j = 0; j < maxDay; j++) {
			calendar.set(Calendar.DAY_OF_MONTH, j + 1);
	    	String dayName = getDayNames().get(calendar.get(Calendar.DAY_OF_WEEK));
	    	Util.Day day = new Util.Day(calendar.get(Calendar.MONTH), monthName, calendar.get(Calendar.DAY_OF_MONTH),dayName);
	    	list.add(day);
		}

		return list;
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