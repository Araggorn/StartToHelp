package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.app.SecurityUtils;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.service.SingleUserService;
import pl.coderslab.charity.service.UsersRolesService;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    SingleUserService singleUserService;
    UsersRolesService usersRolesService;

    public ProfileController(SingleUserService singleUserService, UsersRolesService usersRolesService) {
        this.singleUserService = singleUserService;
        this.usersRolesService = usersRolesService;
    }

    @GetMapping("profile")
    public String edit (Model model){
        SingleUser user = singleUserService.getByEmail(SecurityUtils.username());
        model.addAttribute("user",user);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("userEmail", user.getEmail());
        return "profile";
    }

    @PostMapping("profile")
    public String update (SingleUser singleUser){
        SingleUser loggedUser = singleUserService.getByEmail(SecurityUtils.username());
        loggedUser.setUsername(singleUser.getUsername());
        loggedUser.setLast_update(LocalDateTime.now().toString());
        singleUserService.add(loggedUser);
        return "profile";
    }

}
