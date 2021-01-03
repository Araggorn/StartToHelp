package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.SingleUser;

import java.util.List;

public interface SingleUserRepository extends JpaRepository <SingleUser, Long>
{
    @Query("Select u from SingleUser u order by u.usersRoles.role desc,u.active desc")
    List<SingleUser> getUsers();

    boolean existsByUsername(String username);
    SingleUser getByUsername(String username);

    boolean existsByEmail(String email);

    @Query("Select u from SingleUser u where u.email = ?1")
    SingleUser getByEmail(String email);

    @Query("Select distinct u from SingleUser u where u.id =?1")
    List<SingleUser> getUser(Long id);

    @Query(value="Select username from users where email = ?1",nativeQuery = true)
    String FindUsernameByEmail(String email);

    @Query(value="Select id from users where email = ?1",nativeQuery = true)
    Long FindUserIdByEmail(String email);

    SingleUser getSingleUserById(Long id);

    @Query(value="Select active from users where id = ?1",nativeQuery = true)
    boolean readyToDelete(Long id);

//    @Query("Select u from SingleUser u where u.activateToken = ?1")
//    SingleUser getUserByActivateToken(String activateToken);

    @Query(value="Select count(d.id) from donations d inner join users u on d.users_id = u.id where u.id = ?1",nativeQuery = true)
    int donationsQtyForSelectedUser(Long id);

    SingleUser getUserByActivateToken(String activateToken);

//    @Modifying
//    @Transactional
//    @Query(value = "delete dc.* from donations d inner join users on d.users_id = users.id inner join donations_categories dc on d.id = dc.donations_id where users_id = ?1",nativeQuery = true)
//    void deleteDonationCategoriesForDeletingUser(Long id);
//
//    @Modifying
//    @Transactional
//    @Query(value = "delete d.* from donations d inner join users on d.users_id = users.id where users_id = ?1",nativeQuery = true)
//    void deleteDonationsForDeletingUser(Long id);
}
