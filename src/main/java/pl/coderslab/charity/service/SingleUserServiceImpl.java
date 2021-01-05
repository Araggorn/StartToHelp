package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.repository.SingleUserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class SingleUserServiceImpl implements SingleUserService {
    private final SingleUserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public SingleUserServiceImpl(SingleUserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registry(SingleUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
      //  user.setActivateToken(SecurityUtils.uuidToken());
        user.setActive(false);
        usersRepository.save(user);
    }

    @Override
    public void add(SingleUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       // users.setActivateToken(SecurityUtils.uuidToken());
        user.setActive(true);
        usersRepository.save(user);
    }

    @Override
    public void addWithoutCodePass(SingleUser user) {
      //  user.setActivateToken(SecurityUtils.uuidToken());
        user.setActive(true);
        usersRepository.save(user);
    }


    @Override
    public List<SingleUser> getUser(Long id) {
        return usersRepository.getUser(id);
    }

    @Override
    public void deactivateUsers(Long id) {

    }


    @Override
    public List<SingleUser> getUsers() {
        return usersRepository.findAll();
    }


    @Override
    public SingleUser findById(Long id) {
        return usersRepository.getOne(id);
    }



    @Override
    public String FindUsernameByEmail(String email) {
        return usersRepository.FindUsernameByEmail(email);
    }

    @Override
    public Long FindUserIdByEmail(String email) {
        return usersRepository.FindUserIdByEmail(email);
    }

    @Override
    public SingleUser getUsersById(Long id) {
        return usersRepository.getSingleUserById(id);
    }




//    @Override
//    public void deactivateUsers(Long id) {
//        SingleUser user = usersRepository.getOne(id);
//        user.setActive(false);
//        user.setLast_update(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
//        user.setChangeBy(SecurityUtils.usernameForActivations());
//        usersRepository.save(users);
//    }

    @Override
    public void activateUsers(Long id) {

    }

    @Override
    public void deleteUsers(Long id) {

    }

//    @Override
//    public void activateUsers(Long id) {
//        User user = usersRepository.getOne(id);
//        users.setActive(true);
//        users.setLast_update(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
//        users.setChangeBy(SecurityUtils.usernameForActivations());
//        usersRepository.save(users);
//    }

//    @Override
//    public void setActivateUserAfterEmailValidation(String activateToken){
//        Users user = usersRepository.getUserByActivateToken(activateToken);
//        user.setActive(true);
//        user.setLast_update(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
//        user.setChangeBy("Activation");
//        user.setActivateToken(SecurityUtils.uuidToken());
//        usersRepository.save(user);
//    }

//    @Override
//    public void deleteUsers(Long id) {
//        Long userId = usersRepository.FindUserIdByEmail(SecurityUtils.usernameForActivations());
//
//        if(usersRepository.donationsQtyForSelectedUser(id) == 0) {
//
//            if (!usersRepository.readyToDelete(id) && !id.equals(userId)) {
//                usersRepository.deleteById(id);
//            }
//
//        }
//        else{
//            if (!usersRepository.readyToDelete(id) && !id.equals(userId)) {
//                usersRepository.deleteDonationCategoriesForDeletingUser(id);
//                usersRepository.deleteDonationsForDeletingUser(id);
//                usersRepository.deleteById(id);
//            }
//        }
//    }

}
