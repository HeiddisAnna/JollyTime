package project.model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "friend") // If you want to specify a table name, you can do so here
public class FriendsModel {

	public class Friend {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		private String name;
	    private String email;
	    
	    public Friend() {
	    }

	    public Friend(String name, String email) {
	        this.name = name;
	        this.email = email;
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	ArrayList<Friend> friends = new ArrayList<Friend>();
	
	public FriendsModel() { }
	
	public FriendsModel(ArrayList<Friend> friends) {
		this.friends = friends;
	}
	
	public Long getId() { 
    	return id; 
    }

    public void setId(Long id) { 
    	this.id = id;
    }
	
	public void addFriend(Friend friend) {
		friends.add(friend);
	}
	
	public ArrayList<Friend> getFriends() {
		return friends;
	}
}
