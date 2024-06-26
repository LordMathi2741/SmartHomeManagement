package com.smartHomeManagement.acme.inventory.application.internal.eventhandlers;

import com.smartHomeManagement.acme.inventory.domain.model.commands.SeedTypesCommand;
import com.smartHomeManagement.acme.inventory.domain.services.SeedTypesCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Event handler for application ready event
 * <p>
 *     - This event handler listens for the application ready event and seeds the status and types
 * </p>
 * @author U202212721 Mathias Alejandro Jave Diaz
 * @version 1.0
 */
@Service
public class ApplicationReadyEventHandler {

    private final Logger logger = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    private final SeedTypesCommandService seedTypesCommandService;

    public ApplicationReadyEventHandler( SeedTypesCommandService seedTypesCommandService) {
        this.seedTypesCommandService = seedTypesCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getApplicationName();
        logger.info("Application {} is ready", applicationName);
        var seedTypesCommand = new SeedTypesCommand();
        seedTypesCommandService.seedTypes(seedTypesCommand);
        logger.info("Seeding status and types");

    }

}
