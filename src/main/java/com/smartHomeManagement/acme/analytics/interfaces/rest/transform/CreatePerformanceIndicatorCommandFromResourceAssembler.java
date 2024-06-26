package com.smartHomeManagement.acme.analytics.interfaces.rest.transform;

import com.smartHomeManagement.acme.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;
import com.smartHomeManagement.acme.analytics.interfaces.rest.resources.CreatePerformanceIndicatorResource;

/**
 * CreatePerformanceIndicatorCommandFromResourceAssembler
 * <p>
 *     - This class is responsible for transforming a CreatePerformanceIndicatorResource into a CreatePerformanceIndicatorCommand.
 *     - It is used to decouple the domain layer from the rest layer.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class CreatePerformanceIndicatorCommandFromResourceAssembler {
    public static CreatePerformanceIndicatorCommand toCommandFromResource(CreatePerformanceIndicatorResource resource){
        return new CreatePerformanceIndicatorCommand(resource.name(), resource.description(), resource.maxValue(), resource.minValue(), resource.deviceType());
    }
}
