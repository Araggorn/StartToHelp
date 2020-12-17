package pl.coderslab.charity.fixtures;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class DonationFixtures {
    private DonationService donationService;
    private InstitutionService institutionService;
    private CategoryService categoryService;
    private List<Donation> donationList = Arrays.asList(
            new Donation(123,"Blablak","Wrocław","50-321", LocalDate.now(), LocalTime.now(),"test"),
            new Donation(987,"Varsovia","Warszawa","00-311", LocalDate.now(), LocalTime.now(),"lalalallaa")
    );
    public DonationFixtures(DonationService donationService, InstitutionService institutionService, CategoryService categoryService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }
    public void loadIntoDB() {
        List<Institution> institutionList = institutionService.findAllInstitutions();
        List<Category> categories = categoryService.findAllCategories();
        for (Donation donation : donationList){
            donationService.add(donation);
        }
        Donation donation1 = donationList.get(0);
        Donation donation2 = donationList.get(1);
        donation1.getCategories().add(categories.get(0));
        donation2.getCategories().add(categories.get(1));
        donation2.getCategories().add(categories.get(2));
        donation1.setInstitution(institutionList.get(0));
        donation2.setInstitution(institutionList.get(1));
        donationService.add(donation1);
        donationService.add(donation2);
    }
}
