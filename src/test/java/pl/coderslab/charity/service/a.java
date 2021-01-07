package pl.coderslab.charity.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
//import pl.coderslab.charity.converter.DonationConverter;
//import pl.coderslab.charity.domain.model.category.Category;
//import pl.coderslab.charity.domain.model.donation.AddressType;
//import pl.coderslab.charity.domain.model.donation.Donation;
//import pl.coderslab.charity.domain.model.donation.PickupType;
//import pl.coderslab.charity.domain.model.institution.Institution;
//import pl.coderslab.charity.domain.repository.DonationRepository;
//import pl.coderslab.charity.repository.DonationRepository;
//import pl.coderslab.charity.request.CreateDonationRequest;
//import pl.coderslab.charity.response.CreateDonationResponse;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//
//@DisplayName("Donation Service Specification")
//class DefaultDonationServiceTest {
//
//    DonationRepository donationRepository;
//    // DonationConverter donationConverter;
//    DonationService cut; // class under test
//
//    @BeforeEach
//    void setUp() {
//        this.donationRepository = Mockito.mock(DonationRepository.class);
//       // this.donationConverter = Mockito.mock(DonationConverter.class);
//        this.cut = new DefaultDonationService(donationRepository);
//    }
//
//    @Test
//    @DisplayName("should return success response")
//    void test1() {
//        CreateDonationRequest request = new CreateDonationRequest();
//
//        CreateDonationResponse response = cut.createDonation(request);
//
//        Assertions.assertNotNull(response);
//        Assertions.assertTrue(response.getSuccess());
//    }
//
//    @Test
//    @DisplayName("should save donation with requested data")
//    void test3() {
//        CreateDonationRequest request = new CreateDonationRequest(8, List.of(1L, 2L), 1L, "street", "city", "zipCode", LocalDate.of(2020, 10, 20), LocalTime.of(12, 0), "komentarz");
//
//        Donation donation = Donation.builder()
//                .quantity(8)
//                .categories(List.of(
//                        Category.builder().id(1L).build(),
//                        Category.builder().id(2L).build()
//                ))
//                .institution(Institution.builder().id(1L).build())
//                .address(AddressType.builder().street("street").city("city").zipCode("zipCode").build())
//                .pickup(PickupType.builder().when(LocalDateTime.of(2020, 10, 20, 12, 0)).comment("komentarz").build())
//                .build();
//
//        Mockito.when(donationConverter.convert(request)).thenReturn(donation);
//
//        cut.createDonation(request);
//
//        ArgumentCaptor<Donation> captor = ArgumentCaptor.forClass(Donation.class);
//        Mockito.verify(donationRepository, Mockito.times(1)).save(captor.capture());
//        Mockito.verify(donationConverter, Mockito.times(1)).convert(request);
//
//        Donation capturedDonation = captor.getValue();
//        Assertions.assertEquals(8, capturedDonation.getQuantity());
//        Assertions.assertEquals("komentarz", donation.getPickup().getComment());
////        org.assertj.core.api.Assertions.assertThat(capturedDonation)
//    }
//
//}
