package project;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Util {
	
	public static class Day {
		public int day;
		public String name;

		public Day(int day, String name) {
			this.day = day;
			this.name = name;
		}
	}
	
	static HashMap<Integer, String> getDayNames() {
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(Calendar.SUNDAY, "Sunnudagur");
		hm.put(Calendar.MONDAY, "Mánudagur");
		hm.put(Calendar.TUESDAY, "Þriðjudagur");
		hm.put(Calendar.WEDNESDAY, "Miðvikudagur");
		hm.put(Calendar.THURSDAY, "Fimmtudagur");
		hm.put(Calendar.FRIDAY, "Föstudagur");
		hm.put(Calendar.SATURDAY, "Laugardagur");
		
		return hm;
		
	}

	public static ArrayList<Day> getMonth(int month) {
		ArrayList<Day> list = new ArrayList<Day>();
		Calendar calendar = Calendar.getInstance();
		
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