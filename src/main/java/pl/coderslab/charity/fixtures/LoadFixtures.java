package pl.coderslab.charity.fixtures;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class LoadFixtures {
    private CategoryFixtures categoryFixture;
    private InstitutionFixtures institutionFixture;
    private DonationFixtures donationFixture;
    public LoadFixtures(CategoryFixtures categoryFixture, InstitutionFixtures institutionFixture, DonationFixtures donationFixture) {
        this.categoryFixture = categoryFixture;
        this.institutionFixture = institutionFixture;
        this.donationFixture = donationFixture;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        categoryFixture.loadIntoDB();
        institutionFixture.loadIntoDB();
        donationFixture.loadIntoDB();
    }
}