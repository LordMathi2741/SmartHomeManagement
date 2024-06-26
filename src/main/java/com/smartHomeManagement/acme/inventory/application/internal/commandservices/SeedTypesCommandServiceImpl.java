package com.smartHomeManagement.acme.inventory.application.internal.commandservices;

import com.smartHomeManagement.acme.inventory.domain.model.commands.SeedTypesCommand;
import com.smartHomeManagement.acme.inventory.domain.model.entities.DeviceTypes;
import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceType;
import com.smartHomeManagement.acme.inventory.domain.services.SeedTypesCommandService;
import com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories.DeviceTypesRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of SeedTypesCommandService
 * <p>
 *     - This class is responsible for implementing the SeedTypesCommandService interface.
 *     - It is used to seed the device types.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Service
public class SeedTypesCommandServiceImpl implements SeedTypesCommandService{
    private final DeviceTypesRepository deviceTypesRepository;

    public SeedTypesCommandServiceImpl(DeviceTypesRepository deviceTypesRepository) {
        this.deviceTypesRepository = deviceTypesRepository;
    }
    @Override
    public void seedTypes(SeedTypesCommand command) {
        Arrays.stream(DeviceType.values()).forEach(deviceType -> {
            if(!deviceTypesRepository.existsByType(deviceType))
                deviceTypesRepository.save(new DeviceTypes(deviceType));
        });

    }
}
