package project.model;

import java.sql.Date;
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
    private Date startDate;
    private Date endDate;


    public Event() {
    }

    public Event(String title, String description, Date startDate, Date endDate, Set<JollyUser> users) {
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
    
    public Date getStartDate() {
    	return startDate;
    }
    
    public void setStartDate(Date startDate) {
    	this.startDate = startDate;
    }

    public Date getEndDate() {
    	return endDate;
    }
    
    public void setEndDate(Date endDate) {
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
    
}

  