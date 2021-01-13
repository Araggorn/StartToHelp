package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.repository.SingleUserRepository;;
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
    public List<SingleUser> getUsers() {
        return usersRepository.findAll();
    }


    @Override
    public SingleUser findById(Long id) {
        return usersRepository.getOne(id);
    }



    @Override
    public String findUsernameByEmail(String email) {
        return usersRepository.FindUsernameByEmail(email);
    }

    @Override
    public Long findUserIdByEmail(String email) {
        return usersRepository.FindUserIdByEmail(email);
    }

    @Override
    public SingleUser getUsersById(Long id) {
        return usersRepository.getSingleUserById(id);
    }

    @Override
    public SingleUser getByEmail(String email) {
        return usersRepository.getByEmail(email);
    }

    @Override
    public void update(SingleUser user) {
        SingleUser user1 = usersRepository.getOne(user.getId());
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.encode(user.getUsername()));
        user1.setEmail(user.getEmail());
        usersRepository.save(user);
    }


    @Override
    public void deleteUsers(Long id) {
        SingleUser user = usersRepository.getOne(id);
        user.setActive(false);
        usersRepository.save(user);

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


}
