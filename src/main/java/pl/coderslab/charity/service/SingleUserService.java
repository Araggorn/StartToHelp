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

        void deactivateUsers(Long id);

        void activateUsers(Long id);

        void deleteUsers(Long id);

        String FindUsernameByEmail(String email);

        Long FindUserIdByEmail(String email);

        SingleUser getUsersById(Long id);

//        Users getUserByActivateToken(String activateToken);
//
//        void setActivateUserAfterEmailValidation(String activateToken);

    }

