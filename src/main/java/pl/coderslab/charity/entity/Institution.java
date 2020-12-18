package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "institution")
@ToString
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @OneToMany(mappedBy="institution")
    private List<Donation> donationList = new ArrayList<>();

    public Institution(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
