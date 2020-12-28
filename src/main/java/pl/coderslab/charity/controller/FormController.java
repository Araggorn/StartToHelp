package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.dto.IntitutionDTO;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class FormController {

    private final DonationService donationService;

    @Autowired
    public FormController(DonationService donationService) {
        this.donationService = donationService;

    }

    @GetMapping("/form")
    public String getform(Model model) {
        model.addAttribute("donation", new Donation());

        List<IntitutionDTO> institutionsList = donationService.listOfInstitutions();
        model.addAttribute("institutions", institutionsList);

        List<CategoryDTO> categoryList = donationService.listOfCategories();
        model.addAttribute("categories", categoryList);

        return "form";
    }

    @PostMapping("form")
    public String donationAdd(Donation donation) {
        donationService.add(donation);
        return "redirect:/form-confirmation";
    }

    @GetMapping("/form-confirmation")
    public String donationConfirmationForm() {
        return "form-confirmation";
    }
}
