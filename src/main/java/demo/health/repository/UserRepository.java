package demo.health.repository;

import demo.health.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {

   @Query("Select  new demo.health.model.User(id,username,password,email,role,person) from User u where u.email= ?1 and u.password =?2")
    User login(String email, String password);

    @Query("Select  new demo.health.model.User(email, password) from User u where u.email= ?1 and u.password =?2")
    User verifyIfExists(String email, String password);
}
