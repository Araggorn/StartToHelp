package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;

    @Autowired
    public HomeController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        
        List<Institution> institutions = institutionService.findAllInstitutions();
        List<Institution> collectEven = institutions.stream()
                .filter(inst -> inst.getId() % 2 == 0)
                .collect(Collectors.toList());

        List<Institution> collectOdd = institutions.stream()
                .filter(inst -> inst.getId() % 2 != 0)
                .collect(Collectors.toList());

        model.addAttribute("qtyOfDonation", donationService.QtyOfDonation());
        model.addAttribute("sumOfDonation", donationService.SumOfDonation());

        model.addAttribute("institutionsEven", collectEven);
        model.addAttribute("institutionsOdd", collectOdd);
        return "index";
    }
}