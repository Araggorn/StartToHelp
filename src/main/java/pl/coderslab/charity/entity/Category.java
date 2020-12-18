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
@Table(name = "category")
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy="categories")
    List<Donation> donations = new ArrayList<>();

    public Category(String name) {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
