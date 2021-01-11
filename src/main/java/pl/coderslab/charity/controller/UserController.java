package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.service.SingleUserService;

import java.util.List;

@Controller
public class UserController {
    private final SingleUserService userService;

    @Autowired
    public UserController(SingleUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userlist")
    public String list(Model model) {
        List<SingleUser> users = userService.getUsers();
        model.addAttribute("users", users);
        return "userlist";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        SingleUser user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String addedit(SingleUser user) {
        userService.update(user);
        return "redirect:/userlist";
    }



    @GetMapping("/user/delete/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.deleteUsers(id);
        return "redirect:/userlist";
    }
}