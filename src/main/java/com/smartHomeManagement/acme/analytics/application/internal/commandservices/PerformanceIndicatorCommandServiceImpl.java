package com.smartHomeManagement.acme.analytics.application.internal.commandservices;

import com.smartHomeManagement.acme.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smartHomeManagement.acme.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;
import com.smartHomeManagement.acme.analytics.domain.model.exceptions.MaxValueMustToBeGreaterThanMinValueException;
import com.smartHomeManagement.acme.analytics.domain.model.exceptions.PerformanceIndicatorWithThisTypeAlreadyExistsException;
import com.smartHomeManagement.acme.analytics.domain.services.PerformanceIndicatorCommandService;
import com.smartHomeManagement.acme.analytics.infrastructure.persistence.jpa.repositories.PerformanceIndicatorRepository;
import com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories.DeviceRepository;
import com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories.DeviceTypesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerformanceIndicatorCommandServiceImpl implements PerformanceIndicatorCommandService {

    private final PerformanceIndicatorRepository performanceIndicatorRepository;
    private final DeviceRepository deviceRepository;
    private final DeviceTypesRepository deviceTypesRepository;

    public PerformanceIndicatorCommandServiceImpl(PerformanceIndicatorRepository performanceIndicatorRepository, DeviceRepository deviceRepository, DeviceTypesRepository deviceTypesRepository) {
        this.performanceIndicatorRepository = performanceIndicatorRepository;
        this.deviceRepository = deviceRepository;
        this.deviceTypesRepository = deviceTypesRepository;
    }
    @Override
    public Optional<PerformanceIndicator> handle(CreatePerformanceIndicatorCommand command) {
        var deviceType = deviceTypesRepository.findByType(command.deviceType());
        if(deviceType == null){
            throw new IllegalArgumentException("There are no device types with this type");
        }
        var devices =  deviceRepository.findDevicesByDeviceTypeId(deviceType.getId());
        if (devices.isEmpty()){
            throw new IllegalArgumentException("There are no devices with this type");
        }
        var performanceIndicator = new PerformanceIndicator(command, devices);
        if(performanceIndicatorRepository.existsByDeviceType(command.deviceType())){
            throw new PerformanceIndicatorWithThisTypeAlreadyExistsException("Performance Indicator with this type already exists");
        }
        if(command.maxValue() < command.minValue()){
            throw new MaxValueMustToBeGreaterThanMinValueException("Max value must to be greater than min value");
        }
        return Optional.of(performanceIndicatorRepository.save(performanceIndicator));
    }
}
