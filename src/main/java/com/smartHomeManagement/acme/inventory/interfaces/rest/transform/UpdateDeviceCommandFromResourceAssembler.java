package com.smartHomeManagement.acme.inventory.interfaces.rest.transform;

import com.smartHomeManagement.acme.inventory.domain.model.commands.UpdateDeviceCommand;
import com.smartHomeManagement.acme.inventory.interfaces.rest.resources.UpdateDeviceResource;
/**
 * UpdateDeviceCommandFromResourceAssembler class
 * <p>
 *     - This class is used to transform a UpdateDeviceResource object into a UpdateDeviceCommand object.
 * </p>
 * @version 1.0
 */
public class UpdateDeviceCommandFromResourceAssembler {
    public static UpdateDeviceCommand toCommandFromResource(int id, UpdateDeviceResource resource){
        return new UpdateDeviceCommand(id, resource.serialNumber(),
                resource.model(), resource.status(),resource.deviceTypeId());
    }
}
