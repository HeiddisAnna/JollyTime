package project.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "JollyUser")
public class JollyUser {

    // Declare that this attribute is the id
    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;
    
    @Column (name = "name")
    private String name;
    
    @Column (name = "password")
    private String password;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CAL_ID")
    private Calendar calendar;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name="Friends",
    		joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="USER_ID"),
    		inverseJoinColumns=@JoinColumn(name="FRIEND_ID", referencedColumnName="USER_ID"))
    private Set<JollyUser> friends;

    
    public JollyUser() {
    }

    public JollyUser(String email, String name, String password) {
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
    
    public Set<JollyUser> getFriends() {
        return friends;
    }
    
    public void setFriends(Set<JollyUser> friends){
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

    public Calendar getCalendar() {
    	return calendar;
    }
    
    public void setCalendar(Calendar calendar) {
    	this.calendar = calendar;
    }
    
    public void addFriend(JollyUser friend) {
    	friends.add(friend);
    }
    
    public Boolean isUserAFriend(String email) {
    	for (JollyUser friend: friends) {
    		if(friend.getEmail().equals(email)) {
    			return true;
    		}
    	}
    	return false;
    }
}
