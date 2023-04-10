package Service;

import Model.Device;

import java.util.List;

public interface DeviceService {
    Device createDevice(Device device);
    Device updateDevice(Long id, Device device);
    void deleteDevice(Long id);
    Device getDeviceById(Long id);
    List<Device> getAllDevices();
    List<Device> getAllDevicesByEntreprise(String nomEntreprise);
}

