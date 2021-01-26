package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.app.SecurityUtils;
import pl.coderslab.charity.entity.Contact;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.repository.ContactRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.SingleUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final SingleUserService userService;
    private final ContactRepository contactRepository;

    @Autowired

    public HomeController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService, SingleUserService userService, ContactRepository contactRepository) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.contactRepository = contactRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("contact", new Contact());

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
        SingleUser user = userService.getByEmail(SecurityUtils.username());
        if (user != null) {
            model.addAttribute("userEmail", user.getEmail());
        }
        return "index";
    }

    @PostMapping("/")
    public String add(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        contactRepository.save(contact);
        return "redirect:/index";
    }
}