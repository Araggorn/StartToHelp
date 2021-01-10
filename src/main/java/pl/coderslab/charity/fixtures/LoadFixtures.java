package pl.coderslab.charity.fixtures;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class LoadFixtures {
    private CategoryFixtures categoryFixture;
    private InstitutionFixtures institutionFixture;
    private DonationFixtures donationFixture;
    private UserRolesFixtures userRolesFixtures;
    private SingleUserFixtures singleUserFixtures;

    public LoadFixtures(CategoryFixtures categoryFixture, InstitutionFixtures institutionFixture, DonationFixtures donationFixture, UserRolesFixtures userRolesFixtures, SingleUserFixtures singleUserFixtures) {
        this.categoryFixture = categoryFixture;
        this.institutionFixture = institutionFixture;
        this.donationFixture = donationFixture;
        this.userRolesFixtures = userRolesFixtures;
        this.singleUserFixtures = singleUserFixtures;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        categoryFixture.loadIntoDB();
        institutionFixture.loadIntoDB();
        userRolesFixtures.loadIntoDB();
        singleUserFixtures.loadIntoDB();
        donationFixture.loadIntoDB();
    }
}