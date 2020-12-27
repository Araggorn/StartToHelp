package pl.coderslab.charity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.converter.CategoryConverter;
import pl.coderslab.charity.converter.InstitutionConverter;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.dto.IntitutionDTO;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DonationServiceImpl implements DonationService {

    DonationRepository donationRepository;
    CategoryRepository categoryRepository;
    InstitutionRepository institutionRepository;

    public DonationServiceImpl(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Donation> findAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Donation findById(Long id) {
        return donationRepository.getOne(id);
    }

    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Object QtyOfDonation() {
        return donationRepository.count();
    }

    @Override
    public Object SumOfDonation() {
        return donationRepository.SumOfDonation();
    }

    @Override
    public List<CategoryDTO> listOfCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<IntitutionDTO> listOfInstitutions() {
        return institutionRepository.findAll().stream()
                .map(InstitutionConverter::toDto)
                .collect(Collectors.toList());
    }
}

