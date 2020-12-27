package pl.coderslab.charity.converter;


import pl.coderslab.charity.dto.IntitutionDTO;
import pl.coderslab.charity.entity.Institution;

public class InstitutionConverter {

    public static IntitutionDTO toDto(Institution institution){
        return IntitutionDTO.builder()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription())
                .build();
    }
}
