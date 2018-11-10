package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.User;
import project.persistence.repositories.PostitNoteRepository;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

@Service
public class PostitNoteServiceImplementation implements PostitNoteService {

    // Instance Variables
    PostitNoteRepository repository;

    // Dependency Injection
    @Autowired
    public PostitNoteServiceImplementation(PostitNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User postitNote) {
        return repository.save(postitNote);
    }

    @Override
    public void delete(User postitNote) {
        repository.delete(postitNote);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAllReverseOrder() {
        // Get all the Postit notes
        List<User> postitNotes = repository.findAll();

        // Reverse the list
        Collections.reverse(postitNotes);

        return postitNotes;
    }

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> findByName(String name) {
        return repository.findByName(name);
    }
}
