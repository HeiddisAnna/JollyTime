package project.service;

import java.util.List;

import project.model.Event;
import project.model.JollyUser;

public interface EventService {

    /**
     * Save a {@link JollyUser}
     * @param postitNote {@link JollyUser} to be saved
     * @return {@link JollyUser} that was saved
     */
    Event save(Event event);

    /**
     * Delete {@link JollyUser}
     * @param postitNote {@link JollyUser} to be deleted
     */
    void delete(Event event);

    /**
     * Get all {@link JollyUser}s
     * @return A list of {@link JollyUser}s
     */
    List<Event> findAll();

    /**
     * Get all {@link JollyUser}s in a reverse order
     * @return A reversed list of {@link JollyUser}s
     */
    List<Event> findAllReverseOrder();

    /**
     * Find a {@link JollyUser} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link JollyUser} with {@link Long id}
     */
    Event findOne(Long id);



}
