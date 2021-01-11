package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class InstitutionController {
    InstitutionService institutionService;

    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
    @GetMapping("/institution")
    public String list(Model model) {
        List<Institution> insti = institutionService.findAllInstitutions();
        model.addAttribute("institutions", insti);
        return "institution";
    }
}
