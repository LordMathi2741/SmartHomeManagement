package com.smartHomeManagement.acme.analytics.domain.services;

import com.smartHomeManagement.acme.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smartHomeManagement.acme.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;

import java.util.Optional;

/**
 * PerformanceIndicatorCommandService interface
 * <p>
 *     - Defines the methods that the PerformanceIndicatorCommandService class must implement.
 *     - It contains the handle method.
 *     - The handle method is used to handle the CreatePerformanceIndicatorCommand command.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public interface PerformanceIndicatorCommandService {

    Optional<PerformanceIndicator> handle(CreatePerformanceIndicatorCommand command);
}
