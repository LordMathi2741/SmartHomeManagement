package com.smartHomeManagement.acme.inventory.interfaces.rest.transform;

import com.smartHomeManagement.acme.inventory.domain.model.commands.CreateDeviceCommand;
import com.smartHomeManagement.acme.inventory.interfaces.rest.resources.CreateDeviceResource;

/**
 * CreateDeviceCommandFromResourceAssembler class
 * <p>
 *     - This class is used to transform a CreateDeviceResource object into a CreateDeviceCommand object.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class CreateDeviceCommandFromResourceAssembler {

    public static CreateDeviceCommand toCommandFromResource(CreateDeviceResource resource){
        return new CreateDeviceCommand(
                resource.serialNumber(),
                resource.model(),
                resource.status(),
                resource.deviceTypeId()
        );
    }
}
