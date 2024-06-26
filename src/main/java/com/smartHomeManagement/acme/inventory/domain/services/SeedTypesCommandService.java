package com.smartHomeManagement.acme.inventory.domain.services;

import com.smartHomeManagement.acme.inventory.domain.model.commands.SeedTypesCommand;

/**
 * Service for seeding device types.
 * <p>
 *     - This service is used to seed the device types in the system.
 * </p>
 * @author U20221721 Mathias Jave Diaz
 * @version 1.0
 */
public interface SeedTypesCommandService {
    void seedTypes(SeedTypesCommand command);
}
