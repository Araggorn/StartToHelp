package pl.coderslab.charity.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.converter.TimeConverter;
import pl.coderslab.charity.entity.UsersRoles;
import pl.coderslab.charity.service.UsersRolesService;

import java.util.Arrays;
import java.util.List;


@Component
public class UserRolesFixtures {
    private UsersRolesService usersRolesService;


    private List<UsersRoles> usersRolesList = Arrays.asList(
            new UsersRoles(null, "ROLE_USER", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), true, "User with access only to content","system"),
            new UsersRoles(null, "ROLE_ADMIN", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), true, "User with access to content and configuration panel","system")
    );

    @Autowired
    public UserRolesFixtures(UsersRolesService usersRolesService) {
        this.usersRolesService = usersRolesService;
    }

    public void loadIntoDB() {
        for (UsersRoles usersRoles : usersRolesList) {
            usersRolesService.add(usersRoles);
        }
    }
}
