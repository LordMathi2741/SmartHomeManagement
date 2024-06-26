package com.smartHomeManagement.acme.inventory.domain.model.commands;

import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceStatus;

/**
 * UpdateDeviceCommand
 * <p>
 *     - This class represents the update device command.
 *     - It contains the device attributes to be updated.
 *     - Declares as record to avoid boilerplate code.
 * </p>
 * @param id
 * @param serialNumber
 * @param model
 * @param status
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public record UpdateDeviceCommand(int id, String serialNumber, String model, DeviceStatus status, int deviceTypeId) {
}
