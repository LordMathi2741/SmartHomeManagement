package com.smartHomeManagement.acme.analytics.application.internal.commandservices;

import com.smartHomeManagement.acme.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smartHomeManagement.acme.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;
import com.smartHomeManagement.acme.analytics.domain.model.exceptions.MaxValueMustToBeGreaterThanMinValueException;
import com.smartHomeManagement.acme.analytics.domain.model.exceptions.PerformanceIndicatorWithThisTypeAlreadyExistsException;
import com.smartHomeManagement.acme.analytics.domain.services.PerformanceIndicatorCommandService;
import com.smartHomeManagement.acme.analytics.infrastructure.persistence.jpa.repositories.PerformanceIndicatorRepository;
import com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerformanceIndicatorCommandServiceImpl implements PerformanceIndicatorCommandService {

    private final PerformanceIndicatorRepository performanceIndicatorRepository;
    private final DeviceRepository deviceRepository;

    public PerformanceIndicatorCommandServiceImpl(PerformanceIndicatorRepository performanceIndicatorRepository, DeviceRepository deviceRepository) {
        this.performanceIndicatorRepository = performanceIndicatorRepository;
        this.deviceRepository = deviceRepository;
    }
    @Override
    public Optional<PerformanceIndicator> handle(CreatePerformanceIndicatorCommand command) {
        var devices =  deviceRepository.findDevicesByDeviceType(command.deviceType());
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
