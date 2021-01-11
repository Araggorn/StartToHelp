package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.SingleUser;

import java.util.List;

public interface SingleUserService {


        void add(SingleUser users);

        void registry(SingleUser users);

        void addWithoutCodePass(SingleUser users);

        List<SingleUser> getUsers();

        SingleUser findById(Long id);

        List<SingleUser> getUser(Long id);

        void deleteUsers(Long id);

        String findUsernameByEmail(String email);

        Long findUserIdByEmail(String email);


        SingleUser getUsersById(Long id);

        SingleUser getByEmail(String email);

        void update(SingleUser user);


//        Users getUserByActivateToken(String activateToken);
//
//        void setActivateUserAfterEmailValidation(String activateToken);

    }

