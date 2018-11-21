package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.model.JollyUser;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface UserRepository extends JpaRepository<JollyUser, Long> {

    JollyUser save(JollyUser user);

    void delete(JollyUser user);

    List<JollyUser> findAll();

    List<JollyUser> findAllByOrderByIdDesc();

    @Query(value = "SELECT p FROM JollyUser p WHERE p.id = ?1")
    JollyUser findOne(Long id);
    
    //@Query(value = "SELECT p FROM JollyUser p WHERE p.email = ?1")
    JollyUser findByEmail(String email);

    List<JollyUser> findByName(String name);
    
    @Query(value = "SELECT p FROM JollyUser p WHERE p.email = ?1 AND p.password = ?2")
    JollyUser doesEmailMatchPassword(String email, String password);
    
    //@Query(value = "SELECT p.USER_ID FROM friends p WHERE p.USER_ID = ?1 AND p.FRIEND_ID = ?2")
    //Long doesIDMatchFriend(Long userID, Long friendID);
}
