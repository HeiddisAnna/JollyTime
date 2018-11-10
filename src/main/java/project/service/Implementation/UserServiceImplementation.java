package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.User;
import project.persistence.repositories.PostitNoteRepository;
import project.persistence.repositories.UserRepository;
import project.service.PostitNoteService;
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
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAllReverseOrder() {
        List<User> users = repository.findAll();
        Collections.reverse(users);

        return users;
    }

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> findByName(String name) {
        return repository.findByName(name);
    }
    
    @Override
    public User findByEmail(String email) {
    	return repository.findByEmail(email);
    }
}
