package pl.coderslab.charity.fixtures;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;
import java.util.Arrays;
import java.util.List;
@Component
public class InstitutionFixtures {
    private InstitutionService institutionService;
    private List<Institution> institutionList = Arrays.asList(
            new Institution("Oboje"," Pomoc dla osób nie posiadających miejsca zamieszkania"),
            new Institution("My i Wy", "Przeciwdziałanie Wam a dawanie Nam")
    );
    public InstitutionFixtures(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
    public void loadIntoDB() {
        for (Institution institution : institutionList){
            institutionService.add(institution);
        }
    }
}
