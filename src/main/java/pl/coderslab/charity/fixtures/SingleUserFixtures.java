package pl.coderslab.charity.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.converter.TimeConverter;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.entity.UsersRoles;
import pl.coderslab.charity.service.UsersRolesService;
import pl.coderslab.charity.service.SingleUserService;

import java.util.Arrays;
import java.util.List;

@Component
public class SingleUserFixtures {

    private SingleUserService singleUserService;
    private UsersRolesService usersRolesService;

    private List<SingleUser> usersList = Arrays.asList(
            new SingleUser(null, "Araggorn", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "olek3lo@o2.pl", true, "system", "Mróz", null),
            new SingleUser(null, "Olek", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "1234@wp.pl", true, "system", "Peterka", null),
            new SingleUser(null, "qba", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "123@wp.pl", true, "system", "Graź", null),
            new SingleUser(null, "Olo", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "olek@olek.wygraj", true, "system", "Rybik", null),
            new SingleUser(null, "Maciek", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "zere@zere.pl", true, "system", "Alonsos", null),
            new SingleUser(null, "Maciuś", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "bajabongo@o2.pl", true, "system", "Bussosiliis", null),
            new SingleUser(null, "Mama", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "olo@bolo.pl", true, "system", "zacharisz", null),
            new SingleUser(null, "admin", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "admin@admin", true, "system", "", null)
    );

    public SingleUserFixtures(SingleUserService singleUserService, UsersRolesService usersRolesService) {
        this.singleUserService = singleUserService;
        this.usersRolesService = usersRolesService;
    }

    public void loadIntoDB() {


        for (SingleUser users : usersList) {

            singleUserService.add(users);
        }
        List<UsersRoles> usersRolesList = usersRolesService.getUsersRoles();
        SingleUser user1 = usersList.get(0);
        SingleUser user2 = usersList.get(1);
        SingleUser user3 = usersList.get(2);
        SingleUser user4 = usersList.get(3);
        SingleUser user5 = usersList.get(4);
        SingleUser user6 = usersList.get(5);
        SingleUser user7 = usersList.get(6);
        SingleUser user8 = usersList.get(7);

//
        user1.setUsersRoles(usersRolesList.get(0));
        user2.setUsersRoles(usersRolesList.get(0));
        user3.setUsersRoles(usersRolesList.get(0));
        user4.setUsersRoles(usersRolesList.get(0));
        user5.setUsersRoles(usersRolesList.get(0));
        user6.setUsersRoles(usersRolesList.get(0));
        user7.setUsersRoles(usersRolesList.get(0));
        user8.setUsersRoles(usersRolesList.get(1));

//
    }
}
