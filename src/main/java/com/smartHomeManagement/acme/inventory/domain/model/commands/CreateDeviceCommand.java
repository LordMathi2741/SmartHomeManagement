package com.smartHomeManagement.acme.inventory.domain.model.commands;

import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceStatus;

/**
 * Create Device Command
 * <p>
 *     - This class represents the create device command.
 *    -  Declares as record with the attributes required to create a new device.
 * </p>
 * @param serialNumber
 * @param model
 * @param status
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public record CreateDeviceCommand(String serialNumber, String model, DeviceStatus status, int deviceTypeId) {
}
