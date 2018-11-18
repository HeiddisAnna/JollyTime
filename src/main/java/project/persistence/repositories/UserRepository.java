package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.model.User;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    void delete(User user);

    List<User> findAll();

    List<User> findAllByOrderByIdDesc();

    @Query(value = "SELECT p FROM User p WHERE p.id = ?1")
    User findOne(Long id);
    
    //@Query(value = "SELECT p FROM User p WHERE p.email = ?1")
    User findByEmail(String email);

    List<User> findByName(String name);
    
    @Query(value = "SELECT p FROM User p WHERE p.email = ?1 AND p.password = ?2")
    User doesEmailMatchPassword(String email, String password);
}
