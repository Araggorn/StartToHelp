package pl.coderslab.charity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.service.SingleUserService;
import pl.coderslab.charity.service.UsersRolesService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class RegistrationController {

    private final SingleUserService userService;
    private final UsersRolesService userRolesService;

    @Autowired
    public RegistrationController(SingleUserService userService, UsersRolesService userRolesService) {
        this.userService = userService;
        this.userRolesService = userRolesService;
    }



    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("user", new SingleUser());
        return "register";
    }

    @PostMapping("register")
    public String registerDone(SingleUser user){
        user.setUsersRoles(userRolesService.getUsersRoles().get(0));
        user.setCreated(LocalDateTime.now().toString());
        user.setLast_update(LocalDateTime.now().toString());
        user.setActive(true);
        userService.add(user);
        return "redirect:/login";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
