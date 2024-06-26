package com.smartHomeManagement.acme.inventory.infrastructure.persistence.jpa.repositories;

import com.smartHomeManagement.acme.shared.domain.model.entities.DeviceTypes;
import com.smartHomeManagement.acme.shared.domain.model.valueobjects.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DeviceTypesRepository interface
 * <p>
 *     - This interface extends JpaRepository to provide CRUD operations on DeviceTypes entity.
 *     - This interface is used to interact with the database.
 *     - Make queries to the database using the methods provided by JpaRepository.
 *     - Used Open close principle to extend the functionality of JpaRepository.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public interface DeviceTypesRepository extends JpaRepository<DeviceTypes, Integer>{
    boolean existsByType(DeviceType type);
    DeviceTypes findByType(DeviceType type);
}
