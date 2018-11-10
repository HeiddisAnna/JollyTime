package project.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

    // Declare that this attribute is the id
    @Id
    @Column(name="USER_ID")
    private Long id;

    private String email;
    private String name;
    private String password;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CAL_ID")
    private JollyCalendar calendar;
    
    @ManyToMany
    @JoinTable(
    		name="friends",
    		joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="USER_ID"),
    		inverseJoinColumns=@JoinColumn(name="FRIEND_ID", referencedColumnName="USER_ID"))
    private Set<User> friends;

    
    public User() {
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Set<User> getFriends() {
        return friends;
    }
    
    public void setFriends(Set<User> friends){
    	this.friends = friends;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JollyCalendar getCalendar() {
    	return calendar;
    }
    
    public void setCalendar(JollyCalendar calendar) {
    	this.calendar = calendar;
    }
}
