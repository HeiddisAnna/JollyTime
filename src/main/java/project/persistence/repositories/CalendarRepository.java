package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.model.Calendar;
import project.model.JollyUser;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    Calendar save(Calendar calendar);

    void delete(Calendar calendar);

    List<Calendar> findAll();


    List<Calendar> findAllByOrderByIdDesc();

    @Query(value = "SELECT p FROM Calendar p WHERE p.id = ?1")
    Calendar findOne(Long id);

}
