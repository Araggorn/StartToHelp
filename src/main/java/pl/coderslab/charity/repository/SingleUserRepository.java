package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.SingleUser;

import java.util.List;

public interface SingleUserRepository extends JpaRepository <SingleUser, Long>
{

//    boolean existsByUsername(String username);
//    SingleUser getByUsername(String username);

    boolean existsByEmail(String email);

    @Query("Select distinct u from SingleUser u where u.id =?1")
  List<SingleUser> getUser(Long id);
//
    @Query(value="Select username from users where email = ?1",nativeQuery = true)
    String FindUsernameByEmail(String email);

    @Query(value="Select id from users where email = ?1",nativeQuery = true)
    Long FindUserIdByEmail(String email);

    SingleUser getSingleUserById(Long id);
    SingleUser getSingleUserByEmail(String email);

    @Query("Select u from SingleUser u where u.email = ?1")
    SingleUser getByEmail(String email);

}
