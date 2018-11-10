package project.model;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DateFormatSymbols;
import java.util.Set;


import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class JollyCalendar {
	
    
    @Id
    @Column(name="CAL_ID")
    private Long id;
    
    @ManyToMany
    @JoinTable(
    		name="CAL_EVENT",
    		joinColumns=@JoinColumn(name="CALENDAR_ID", referencedColumnName="CAL_ID"),
    		inverseJoinColumns=@JoinColumn(name="EVENT_ID", referencedColumnName="EVENT_ID"))
    private Set<Event> events;
    
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy="calendar")
    private User user;
    

    public JollyCalendar() {
    	
    }
    	
    public static void main(String[] args) {
    	Calendar date = GregorianCalendar.getInstance();
    	date.setTime(new Date("2018/11/10"));
    	
    	String space = " ";
    	DateFormatSymbols dfs = new DateFormatSymbols();
    	String[] daysOfWeek = dfs.getShortWeekdays();
    	for (int i = 0; i < daysOfWeek.length; i++) {
    		daysOfWeek[i] = daysOfWeek[i]+ space + space;
    	}
    	
    	String monthName = 
    			dfs.getMonths()[date.get(Calendar.MONTH)];
    	String yearMonthStr = 
    			String.format("%s - %s", date.get(Calendar.YEAR), monthName);
    	
    	int cellLength = daysOfWeek[1].length();
    	int lineLength = cellLength * daysOfWeek.length;
    	int padding = lineLength / 2 + 1 - yearMonthStr.length()/2;
    	
    	System.out.println(yearMonthStr);
    	System.out.println(String.join("", daysOfWeek));
    	
    	int currDayOfWeekValue = date.get(Calendar.DAY_OF_WEEK) - 1;
    	int currentMonth = date.get(Calendar.MONTH);
    	
    	String prevPadding = 
    			padLeft("", currDayOfWeekValue * cellLength, ' ');
    	
    	while (date.get(Calendar.MONTH) == currentMonth) {
    		while(currDayOfWeekValue < daysOfWeek.length - 1 &&
    				date.get(Calendar.MONTH) == currentMonth) {
    			String day = Integer.toString(
    					date.get(Calendar.DAY_OF_MONTH));
    			
    			String cell = String.format(
    					"%s%s%s%s",
    					prevPadding,
    					space,
    					padLeft(day, 3, ' '),
    					space);
    			prevPadding = "";
    			
    			System.out.print(cell);
    			
    			date.add(Calendar.DAY_OF_MONTH, 1);
    			currDayOfWeekValue++;
    		} // end of inner while
    		
    		currDayOfWeekValue = 0;
    		
    		System.out.println();
    	} // end of outer while
    }
    
    public static String padLeft (String self, int totalWidth, char paddingChar ) {
		
		if ( totalWidth <= 0 ) 
			return self;
		
		StringBuilder sb = new StringBuilder( self );
		
		while ( sb.length() < totalWidth ) {
			
			sb.insert( 0, paddingChar );
		}
		
		return sb.toString();
    }

    public JollyCalendar(Set<Event> events, User user) {
        this.events = events;
        this.user = user;
    }
    
    public Set<Event> getEvents() {
    	return events;
    }
    
    public void setEvents(Set<Event> events) {
    	this.events = events;
    }
    
    public User getUser() {
    	return user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public Long getID() {
    	return id;
    }
    
    public void setID(Long id) {
    	this.id = id;
    }
    
}
