package com.smartHomeManagement.acme.analytics.interfaces.rest.resources;

import com.smartHomeManagement.acme.shared.domain.model.valueobjects.DeviceType;

/**
 * CreatePerformanceIndicatorResource class
 * <p>
 *     - This class represents the CreatePerformanceIndicatorResource.
 *     - It contains the attributes of the CreatePerformanceIndicatorResource entity.
 * </p>
 * @param name
 * @param description
 * @param maxValue
 * @param minValue
 * @param deviceType
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public record CreatePerformanceIndicatorResource(String name, String description, Double maxValue, Double minValue,
                                                 DeviceType deviceType) {
}
