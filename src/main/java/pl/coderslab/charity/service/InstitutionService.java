package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;

import java.util.List;


public interface InstitutionService {
    List<Institution> findAllInstitutions();

    Institution findById(Long id);

    void add(Institution institution);

}
