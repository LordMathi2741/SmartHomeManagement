package com.smartHomeManagement.acme.analytics.domain.model.commands;

import com.smartHomeManagement.acme.shared.domain.model.valueobjects.DeviceType;

/**
 * CreatePerformanceIndicatorsCommand
 * <p>
 *      - This class represents the CreatePerformanceIndicatorsCommand command.
 *      - It contains the attributes of the CreatePerformanceIndicatorsCommand command.
 * </p>
 * @param name
 * @param description
 * @param maxValue
 * @param minValue
 * @param deviceType
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public record CreatePerformanceIndicatorCommand(String name, String description, Double maxValue, Double minValue,
                                                DeviceType deviceType) {
}
