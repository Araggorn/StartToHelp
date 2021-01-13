package pl.coderslab.charity.service;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.app.SecurityUtils;
import pl.coderslab.charity.entity.UsersRoles;
import pl.coderslab.charity.repository.UsersRolesRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UsersRolesServiceImpl implements UsersRolesService {
    private final UsersRolesRepository usersRolesRepository;

    public UsersRolesServiceImpl(UsersRolesRepository usersRolesRepository) {
        this.usersRolesRepository = usersRolesRepository;
    }


    @Override
    public void add(UsersRoles usersroles) {
        usersRolesRepository.save(usersroles);
    }

    @Override
    public List<UsersRoles> getUsersRoles() {
        return usersRolesRepository.findAll();
    }

    @Override
    public List<UsersRoles> getDeactivatedUsersRoles() {
        return null;
    }


    @Override
    public UsersRoles findById(Long id) {
        return usersRolesRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {

    }
}
