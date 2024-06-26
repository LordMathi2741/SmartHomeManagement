package com.smartHomeManagement.acme.inventory.domain.services;

import com.smartHomeManagement.acme.inventory.domain.model.aggregates.Device;
import com.smartHomeManagement.acme.inventory.domain.model.commands.CreateDeviceCommand;
import com.smartHomeManagement.acme.inventory.domain.model.commands.UpdateDeviceCommand;

import java.util.Optional;

/**
 * DeviceCommandService interface
 * <p>
 *     - This interface provides the methods to handle the device commands.
 *     - Defines the contract for the DeviceCommandService.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public interface DeviceCommandService {
    Optional<Device> handle(CreateDeviceCommand command);
    Optional<Device> handle(UpdateDeviceCommand command);

}
