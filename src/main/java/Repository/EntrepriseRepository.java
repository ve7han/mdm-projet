package Repository;

import Model.Entreprise;
import Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
    Entreprise findByNomEntreprise(String nomentreprise);

}
