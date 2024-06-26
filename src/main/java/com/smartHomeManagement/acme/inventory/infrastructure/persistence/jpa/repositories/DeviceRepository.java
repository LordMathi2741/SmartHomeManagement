package com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories;

import com.smartHomeManagement.acme.inventory.domain.model.aggregates.Device;
import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceStatus;
import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DeviceRepository interface
 * <p>
 *     - This interface extends JpaRepository to provide CRUD operations on Device entity.
 *     - This interface is used to interact with the database.
 *     - Make queries to the database using the methods provided by JpaRepository.
 *     - Used Open close principle to extend the functionality of JpaRepository.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    boolean existsByStatus(DeviceStatus status);
    boolean existsBySerialNumber(String serialNumber);
}
