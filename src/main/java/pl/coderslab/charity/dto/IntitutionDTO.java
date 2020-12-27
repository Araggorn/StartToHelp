package pl.coderslab.charity.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntitutionDTO {

        private Long id;
        private String name;
        private String description;
    }
}
