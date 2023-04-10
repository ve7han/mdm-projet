package Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marque;
    private String modele;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomentreprise")
    private Entreprise entreprise;
    private String nomentreprise;

}
