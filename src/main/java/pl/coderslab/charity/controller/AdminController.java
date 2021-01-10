package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("admin")
public class AdminController {
    private final SingleUserService userService;
    private final UsersRolesService userRolesService;

    @Autowired
    public AdminController(SingleUserService userService, UsersRolesService userRolesService) {
        this.userService = userService;
        this.userRolesService = userRolesService;
    }

    @GetMapping("profile")
    public String update(Model model) {
        SingleUser user = userService.getByEmail(SecurityUtils.username());
        model.addAttribute("user", user);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("userEmail", user.getEmail());
        return "admin/profile";
    }

    @PostMapping("profile")
    public String updateDone(SingleUser user) {
        user.setUsersRoles(userRolesService.getUsersRoles().get(1));
        user.setLast_update(LocalDateTime.now().toString());
        user.setCreated(user.getCreated());
        user.setActive(true);
        userService.add(user);
        return "redirect:/login";
    }

}
