package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.UserInfoModel;
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
    public UserInfoModel save(UserInfoModel postitNote) {
        return repository.save(postitNote);
    }

    @Override
    public void delete(UserInfoModel postitNote) {
        repository.delete(postitNote);
    }

    @Override
    public List<UserInfoModel> findAll() {
        return repository.findAll();
    }

    @Override
    public List<UserInfoModel> findAllReverseOrder() {
        // Get all the Postit notes
        List<UserInfoModel> postitNotes = repository.findAll();

        // Reverse the list
        Collections.reverse(postitNotes);

        return postitNotes;
    }

    @Override
    public UserInfoModel findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<UserInfoModel> findByName(String name) {
        return repository.findByName(name);
    }
}
