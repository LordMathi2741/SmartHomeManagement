package com.smartHomeManagement.acme.inventory.application.internal.commandservices;
import com.smartHomeManagement.acme.inventory.domain.model.aggregates.Device;
import com.smartHomeManagement.acme.inventory.domain.model.commands.CreateDeviceCommand;
import com.smartHomeManagement.acme.inventory.domain.model.commands.UpdateDeviceCommand;
import com.smartHomeManagement.acme.inventory.domain.model.exceptions.DeviceTypeDoesntExistsException;
import com.smartHomeManagement.acme.inventory.domain.model.exceptions.SerialNameAlreadyExistsException;
import com.smartHomeManagement.acme.inventory.domain.services.DeviceCommandService;
import com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories.DeviceRepository;
import com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories.DeviceTypesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final DeviceRepository deviceRepository;
    private final DeviceTypesRepository deviceTypesRepository;

    public DeviceCommandServiceImpl(DeviceRepository deviceRepository, DeviceTypesRepository deviceTypesRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceTypesRepository = deviceTypesRepository;
    }
    @Override
    public Optional<Device> handle(CreateDeviceCommand command) {
        if(deviceRepository.existsBySerialNumber(command.serialNumber())){
            throw new SerialNameAlreadyExistsException("Serial number already exists");
        }
        if (!deviceTypesRepository.existsById(command.deviceTypeId())){
            throw new DeviceTypeDoesntExistsException("Device type doesn't exist");
        }
        var deviceType = deviceTypesRepository.findById(command.deviceTypeId());
        var device = new Device(command,deviceType.orElseThrow());
        return Optional.of(deviceRepository.save(device));
    }

    @Override
    public Optional<Device> handle(UpdateDeviceCommand command) {
        if(!deviceRepository.existsById(command.id())){
            return Optional.empty();
        }
        var deviceType = deviceTypesRepository.findById(command.deviceTypeId());
        var deviceToUpdate = deviceRepository.findById(command.id());
        deviceToUpdate.get().setModel(command.model());
        deviceToUpdate.get().setSerialNumber(command.serialNumber());
        deviceToUpdate.get().setStatus(command.status());
        deviceToUpdate.get().setDeviceTypes(deviceType.orElseThrow());

        return Optional.of(deviceRepository.save(deviceToUpdate.get()));
    }
}
