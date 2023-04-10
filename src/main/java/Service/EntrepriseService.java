package Service;

import Model.Device;
import Model.Entreprise;

import java.util.List;

public interface EntrepriseService {

    Entreprise createEntreprise(Entreprise entreprise);
    Entreprise updateEntreprise(Long identreprise, Entreprise entreprise);
    void deleteEntreprise(Long identreprise);
    Entreprise getEntrepriseById(Long identreprise);
    List<Entreprise> getAllEntreprises();
    Entreprise getEntrepriseByNomEntreprise(String nomEntreprise);
}

