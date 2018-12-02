package project.model;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "event") 
public class Event {

 
    @Id
    @Column(name="EVENT_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy="events")
    private Set<JollyUser> users;

    public String title;
    private String description;
    
    @Column(name="startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;
    
    @Column(name="endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endDate;


    public Event() {
    }

    public Event(String title, String description, Calendar startDate, Calendar endDate, Set<JollyUser> users) {
    	this.title = title;
    	this.startDate = startDate;
    	this.endDate = endDate;
    	this.users = users;
    	this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public Calendar getStartDate() {
    	return startDate;
    }
    
    public void setStartDate(Calendar startDate) {
    	this.startDate = startDate;
    }

    public Calendar getEndDate() {
    	return endDate;
    }
    
    public void setEndDate(Calendar endDate) {
    	this.endDate = endDate;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    
    public Set<JollyUser> getUsers() {
    	return users;
    }
    
    public void setUsers(Set<JollyUser> users) {
    	this.users = users;
    }
    
    public void addUser(JollyUser user) {
    	users.add(user);
    }

    public List<Integer> getDays(int month, int year) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.MONTH, startDate.get(Calendar.MONTH));
    	calendar.set(Calendar.YEAR, startDate.get(Calendar.YEAR));
    	calendar.set(Calendar.DAY_OF_MONTH, startDate.get(Calendar.DAY_OF_MONTH));
    	
    	int nextMonth = startDate.get(Calendar.MONTH) + 1;
    	int yearOfNextMonth = startDate.get(Calendar.YEAR);
    	if (month > 11) {
    		month = 0;
    		yearOfNextMonth += 1;
    	}
    	
    	Calendar firstDayOfNextMonth = Calendar.getInstance();
    	firstDayOfNextMonth.set(Calendar.MONTH, nextMonth);
    	firstDayOfNextMonth.set(Calendar.YEAR, yearOfNextMonth);
    	firstDayOfNextMonth.set(Calendar.DAY_OF_MONTH, 1);
    	
    	ArrayList<Integer> days = new ArrayList<Integer>();
    	
    	while (calendar.getTimeInMillis() < endDate.getTimeInMillis() && calendar.getTimeInMillis() < firstDayOfNextMonth.getTimeInMillis()) {
    		Integer day = (Integer) calendar.get(Calendar.DAY_OF_MONTH);
    		days.add(day);
    		calendar.add(Calendar.DATE, 1);
    	}
    	return days;
    }
    
    public int getLength() {
    	Date start = startDate.getTime();
    	Date end = endDate.getTime();
    	
    	Long diff = (end.getTime() - start.getTime())/1000;
    	return Math.toIntExact(diff);
    }
    
    /* 
     * Fall sem skilar true ef eventinn sem tekinn er inn í fallið (that)
     * byrjar á eftir eventnum sem við erum í (this).  
     * Annars skilar fallið false
     */
    public Boolean startsBefore(Event that) {
    	Date thisStartDate = this.startDate.getTime();
    	Date thatStartDate = that.startDate.getTime();
    	
    	Long diff = thisStartDate.getTime() - thatStartDate.getTime();
    	if (diff <= 0) return true;
    	return false;
    }
    
    /* 
     * Fall sem skilar true ef eventinn sem tekinn er inn í fallið (that)
     * endar á eftir eventnum sem við erum í (this).  
     * Annars skilar fallið false
     */
    public Boolean endsAfter(Event that) {
    	Date thisEndDate = this.endDate.getTime();
    	Date thatEndDate = that.endDate.getTime();
    	
    	Long diff = thisEndDate.getTime() - thatEndDate.getTime();
    	if (diff >= 0) return true;
    	return false;
    }
    
}

  