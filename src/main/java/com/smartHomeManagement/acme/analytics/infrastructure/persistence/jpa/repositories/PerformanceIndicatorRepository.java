package com.smartHomeManagement.acme.analytics.infrastructure.persistence.jpa.repositories;

import com.smartHomeManagement.acme.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smartHomeManagement.acme.shared.domain.model.valueobjects.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PerformanceIndicatorRepository
 * <p>
 *     - This interface represents the PerformanceIndicatorRepository repository.
 *     - It contains the methods to interact with the PerformanceIndicator entity.
 * </p>
 */
public interface PerformanceIndicatorRepository extends JpaRepository<PerformanceIndicator, Integer>{
    boolean existsByDeviceType(DeviceType deviceType);
}
