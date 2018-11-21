package project.service;

import java.util.List;

import project.model.Calendar;
import project.model.JollyUser;

public interface CalendarService {

    /**
     * Save a {@link JollyUser}
     * @param postitNote {@link JollyUser} to be saved
     * @return {@link JollyUser} that was saved
     */
    Calendar save(Calendar calendar);

    /**
     * Delete {@link JollyUser}
     * @param postitNote {@link JollyUser} to be deleted
     */
    void delete(Calendar calendar);

    /**
     * Get all {@link JollyUser}s
     * @return A list of {@link JollyUser}s
     */
    List<Calendar> findAll();

    /**
     * Get all {@link JollyUser}s in a reverse order
     * @return A reversed list of {@link JollyUser}s
     */
    List<Calendar> findAllReverseOrder();

    /**
     * Find a {@link JollyUser} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link JollyUser} with {@link Long id}
     */
    Calendar findOne(Long id);

}
