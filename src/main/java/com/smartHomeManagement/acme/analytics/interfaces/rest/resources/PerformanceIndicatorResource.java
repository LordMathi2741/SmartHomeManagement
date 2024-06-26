package com.smartHomeManagement.acme.analytics.interfaces.rest.resources;

/**
 *  PerformanceIndicatorResource
 *  <p>
 *      - This class represents the PerformanceIndicatorResource.
 *      - It contains the attributes of the PerformanceIndicatorResource entity.
 *  </p>
 * @param name
 * @param description
 * @param maxValue
 * @param minValue
 * @param deviceType
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */

public record PerformanceIndicatorResource(int id,String name, String description, Double maxValue, Double minValue,
                                           String deviceType) {
}
