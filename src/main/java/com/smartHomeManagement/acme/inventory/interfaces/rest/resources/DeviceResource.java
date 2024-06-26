package com.smartHomeManagement.acme.inventory.interfaces.rest.resources;

import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceStatus;

public record DeviceResource(int Id,String serialNumber, String model, String status, int deviceTypeId) {
}
