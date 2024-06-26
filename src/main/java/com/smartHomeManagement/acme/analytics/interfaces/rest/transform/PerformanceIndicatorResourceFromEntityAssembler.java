package com.smartHomeManagement.acme.analytics.interfaces.rest.transform;

import com.smartHomeManagement.acme.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smartHomeManagement.acme.analytics.interfaces.rest.resources.PerformanceIndicatorResource;

public class PerformanceIndicatorResourceFromEntityAssembler {

    public static PerformanceIndicatorResource toResourceFromEntity(PerformanceIndicator performanceIndicator) {
        return new PerformanceIndicatorResource(performanceIndicator.getId(), performanceIndicator.getName(), performanceIndicator.getDescription(), performanceIndicator.getMaxValue(), performanceIndicator.getMinValue(), performanceIndicator.getDeviceType().name());
    }
}
