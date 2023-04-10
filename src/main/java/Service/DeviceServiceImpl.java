package Service;

import Model.Device;
import Model.Entreprise;
import Repository.DeviceRepository;
import Repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeviceServiceImpl implements DeviceService {
    private DeviceRepository deviceRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public Device createDevice(Device device) {
        Entreprise entreprise = entrepriseRepository.findByNomEntreprise(device.getNomentreprise());
        device.setEntreprise(entreprise);
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Long id, Device device) {
        Device existingDevice = deviceRepository.findById(id).orElse(null);
        if(existingDevice != null) {
            existingDevice.setMarque(device.getMarque());
            existingDevice.setModele(device.getModele());
            existingDevice.setNomentreprise(device.getNomentreprise());
            Entreprise entreprise = entrepriseRepository.findByNomEntreprise(device.getNomentreprise());
            existingDevice.setEntreprise(entreprise);
            return deviceRepository.save(existingDevice);
        }
        return null;
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> getAllDevicesByEntreprise(String nomEntreprise) {
        return deviceRepository.findByEntrepriseNomentreprise(nomEntreprise);
    }
}