package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;

import java.util.List;


public interface DonationService {
    List<Donation> findAllDonations();

    Donation findById(Long id);

    void add(Donation donation);


    Object QtyOfDonation();

    Object SumOfDonation();
}
