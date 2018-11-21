package project.model;


import project.model.JollyUser;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class Calendar {
	
    
    @Id
    @Column(name="CAL_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(
    		name="CAL_EVENT",
    		joinColumns=@JoinColumn(name="CALENDAR_ID", referencedColumnName="CAL_ID"),
    		inverseJoinColumns=@JoinColumn(name="EVENT_ID", referencedColumnName="EVENT_ID"))
    private Set<Event> events;
    
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy="calendar")
    private JollyUser user;
    

    public Calendar() {
    }

    public Calendar(Set<Event> events, JollyUser user) {
        this.events = events;
        this.user = user;
    }
    
    public Set<Event> getEvents() {
    	return events;
    }
    
    public void setEvents(Set<Event> events) {
    	this.events = events;
    }
    
    public JollyUser getUser() {
    	return user;
    }
    
    public void setUser(JollyUser user) {
    	this.user = user;
    }
    
    public Long getID() {
    	return id;
    }
    
    public void setID(Long id) {
    	this.id = id;
    }
    
}
