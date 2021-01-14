package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository <Donation, Long> {


    @Query("Select d from Donation d join fetch d.categories c")
    List<Donation> getDonationsWithCategories();

    @Query(value = "Select sum(quantity) from donation",nativeQuery = true)
    int SumOfDonation();
}
