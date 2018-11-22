package project.service;

import java.util.List;

import project.model.JollyUser;

public interface UserService {

    /**
     * Save a {@link JollyUser}
     * @param postitNote {@link JollyUser} to be saved
     * @return {@link JollyUser} that was saved
     */
    JollyUser save(JollyUser user);

    /**
     * Delete {@link JollyUser}
     * @param postitNote {@link JollyUser} to be deleted
     */
    void delete(JollyUser user);

    /**
     * Get all {@link JollyUser}s
     * @return A list of {@link JollyUser}s
     */
    List<JollyUser> findAll();

    /**
     * Get all {@link JollyUser}s in a reverse order
     * @return A reversed list of {@link JollyUser}s
     */
    List<JollyUser> findAllReverseOrder();

    /**
     * Find a {@link JollyUser} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link JollyUser} with {@link Long id}
     */
    JollyUser findOne(Long id);

    /**
     * Find all {@link JollyUser}s with {@link String name}
     * @param name {@link String}
     * @return All {@link JollyUser}s with the {@link String name} passed
     */
    List<JollyUser> findByName(String name);
    
    JollyUser findByEmail(String email);
    
    JollyUser doesEmailMatchPassword(String email, String password);
    
    Long doesIDMatchFriend(Long userID, Long friendID);

}
