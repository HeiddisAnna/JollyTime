package project.service;

import java.util.List;

import project.model.User;

public interface UserService {

    /**
     * Save a {@link User}
     * @param postitNote {@link User} to be saved
     * @return {@link User} that was saved
     */
    User save(User user);

    /**
     * Delete {@link User}
     * @param postitNote {@link User} to be deleted
     */
    void delete(User user);

    /**
     * Get all {@link User}s
     * @return A list of {@link User}s
     */
    List<User> findAll();

    /**
     * Get all {@link User}s in a reverse order
     * @return A reversed list of {@link User}s
     */
    List<User> findAllReverseOrder();

    /**
     * Find a {@link User} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link User} with {@link Long id}
     */
    User findOne(Long id);

    /**
     * Find all {@link User}s with {@link String name}
     * @param name {@link String}
     * @return All {@link User}s with the {@link String name} passed
     */
    List<User> findByName(String name);
    
    User findByEmail(String email);

}
