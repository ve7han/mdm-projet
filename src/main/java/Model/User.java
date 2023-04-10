package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private String username;
    private String nom;
    private String prenom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codeprofile")
    private Profile profile;
    private String codeprofile;
    private String email;
    private String password;
    private LocalDate date_naissance;

}
