package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long identreprise;
    private String nomentreprise;
    private String adresse;
    private int capitale;
    private int numemployee;
    private String fondateur;
    private LocalDate datecreation;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Device> devices;

}
