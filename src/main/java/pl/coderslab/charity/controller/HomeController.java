package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;


@Controller
@Transactional
public class HomeController {

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }
}
