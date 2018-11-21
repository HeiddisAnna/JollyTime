package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.JollyUser;
import project.persistence.repositories.EventRepository;
import project.persistence.repositories.UserRepository;
import project.service.EventService;
import project.service.UserService;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    // Instance Variables
    UserRepository repository;
    
    public UserServiceImplementation() {}

    // Dependency Injection
    @Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public JollyUser save(JollyUser user) {
        return repository.save(user);
    }

    @Override
    public void delete(JollyUser user) {
        repository.delete(user);
    }

    @Override
    public List<JollyUser> findAll() {
        return repository.findAll();
    }

    @Override
    public List<JollyUser> findAllReverseOrder() {
        List<JollyUser> users = repository.findAll();
        Collections.reverse(users);

        return users;
    }

    @Override
    public JollyUser findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<JollyUser> findByName(String name) {
        return repository.findByName(name);
    }
    
    @Override
    public JollyUser findByEmail(String email) {
    	return repository.findByEmail(email);
    }
    
    @Override
    public JollyUser doesEmailMatchPassword(String email, String password) {
    	return repository.doesEmailMatchPassword(email, password);
    }
    
    /*
    @Override
    public Long doesIDMatchFriend(Long userID, Long friendID) {
    	return new Long(0); //repository.doesIDMatchFriend(userID, friendID);
    }
    */
    
}
