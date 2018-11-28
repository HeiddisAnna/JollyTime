package project.model;


import java.util.GregorianCalendar;
import java.util.Date;
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
    
    private String title;
    private String description;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;


    public Event() {
    }

    public Event(String title, String description, GregorianCalendar startDate, GregorianCalendar endDate, Set<JollyUser> users) {
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
    
    public GregorianCalendar getStartDate() {
    	return startDate;
    }
    
    public void setStartDate(GregorianCalendar startDate) {
    	this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
    	return endDate;
    }
    
    public void setEndDate(GregorianCalendar endDate) {
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
    
    public Long getLength() {
    	Date start = startDate.getTime();
    	Date end = endDate.getTime();
    	
    	Long diff = (end.getTime() - start.getTime())/1000;
    	return diff;
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

  