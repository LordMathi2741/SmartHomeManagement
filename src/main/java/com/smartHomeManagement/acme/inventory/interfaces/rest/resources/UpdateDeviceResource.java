package com.smartHomeManagement.acme.inventory.interfaces.rest.resources;

import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceStatus;

public record UpdateDeviceResource(String serialNumber, String model, DeviceStatus status, int deviceTypeId) {
}
