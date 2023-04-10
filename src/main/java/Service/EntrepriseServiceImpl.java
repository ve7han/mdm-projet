package Service;

import Model.Device;
import Model.Entreprise;
import Repository.EntrepriseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntrepriseServiceImpl implements EntrepriseService{
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).orElse(null);
    }

    @Override
    public Entreprise createEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise updateEntreprise(Long identreprise, Entreprise entreprise) {
        Entreprise updatedEntreprise = entrepriseRepository.findById(identreprise).orElse(null);
        if (updatedEntreprise != null) {
            updatedEntreprise.setNomentreprise(entreprise.getNomentreprise());
            updatedEntreprise.setAdresse(entreprise.getAdresse());
            updatedEntreprise.setCapitale(entreprise.getCapitale());
            updatedEntreprise.setNumemployee(entreprise.getNumemployee());
            updatedEntreprise.setFondateur(entreprise.getFondateur());
            updatedEntreprise.setDatecreation(entreprise.getDatecreation());
            updatedEntreprise.setDevices(entreprise.getDevices());
            return entrepriseRepository.save(updatedEntreprise);
        }
        return null;
    }

    @Override
    public void deleteEntreprise(Long identreprise) {
        entrepriseRepository.deleteById(identreprise);
    }


    @Override
    public Entreprise getEntrepriseByNomEntreprise(String nomEntreprise) {
        return entrepriseRepository.findByNomEntreprise(nomEntreprise);
    }
}