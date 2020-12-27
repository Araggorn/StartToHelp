package pl.coderslab.charity.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "donation")

public class Donation {

    public Donation(Long o, int i, Object o1, Object o2, String k, String p, String s, LocalDate now, LocalTime now1, String test) {
    }

    public Donation(int i, String varsovia, String warszawa, String s, LocalDate now, LocalTime now1, String lalalallaa) {
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", pickUpTime=" + pickUpTime +
                ", pickUpComment='" + pickUpComment + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    private Institution institution;

    private String city;

    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate pickUpDate;

    @DateTimeFormat(pattern = "hh-mm")
    private LocalTime pickUpTime;

    private String pickUpComment;

    private String street;

    private String phoneNumber;

    public Donation(Long id, Integer quantity, String city, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment) {
        this.id = id;
        this.quantity = quantity;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

}
