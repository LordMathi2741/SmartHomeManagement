package com.smartHomeManagement.acme.inventory.interfaces.rest.transform;

import com.smartHomeManagement.acme.inventory.domain.model.aggregates.Device;
import com.smartHomeManagement.acme.inventory.interfaces.rest.resources.DeviceResource;

/**
 * DeviceResourceFromEntityAssembler class
 * <p>
 *     - This class is used to transform a Device entity to a DeviceResource.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class DeviceResourceFromEntityAssembler {

    public static DeviceResource toResourceFromEntity(Device device){
        return new DeviceResource(device.getId(), device.getSerialNumber(),
                device.getModel(), device.getStatus().name().toLowerCase(), device.getDeviceTypes().getId());
    }
}
