package pl.coderslab.charity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@Transactional
@Slf4j
public class InstitutionServiceImpl implements InstitutionService{

   InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAllInstitutions() {
        return institutionRepository.findAll();
    }


    @Override
    public Institution findById(Long id) {
        return institutionRepository.getOne(id);
    }

    @Override
    public void add(Institution institution) {
        institutionRepository.save(institution);

    }

}
