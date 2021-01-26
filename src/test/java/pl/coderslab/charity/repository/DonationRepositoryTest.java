//package pl.coderslab.charity.repository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.test.context.junit4.SpringRunner;
//import pl.coderslab.charity.entity.Category;
//import pl.coderslab.charity.entity.Donation;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//class DonationRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//    @Autowired
//    private DonationRepository donationRepository;
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//
//
//
//    @Test
//    @DisplayName("Get Donation with Categories test")
//    public void test1() {
////given
//        List<Category> categories = categoryRepository.findAll();
//        Donation first = new Donation();
//        Donation second = new Donation();
//        first.getCategories().add(categories.get(1));
//        first.getCategories().add(categories.get(2));
//        second.getCategories().add(categories.get(1));
//        entityManager.persist(first);
//        entityManager.persist(second);
//
////when
//        List<Donation> results =
//                donationRepository.getDonationsWithCategories();
////then
//                Assertions.assertThat(results).
//    }
//}