package com.smartHomeManagement.acme.inventory.interfaces.rest;

import com.smartHomeManagement.acme.inventory.domain.model.commands.UpdateDeviceCommand;
import com.smartHomeManagement.acme.inventory.domain.services.DeviceCommandService;
import com.smartHomeManagement.acme.inventory.interfaces.rest.resources.CreateDeviceResource;
import com.smartHomeManagement.acme.inventory.interfaces.rest.resources.DeviceResource;
import com.smartHomeManagement.acme.inventory.interfaces.rest.resources.UpdateDeviceResource;
import com.smartHomeManagement.acme.inventory.interfaces.rest.transform.CreateDeviceCommandFromResourceAssembler;
import com.smartHomeManagement.acme.inventory.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import com.smartHomeManagement.acme.inventory.interfaces.rest.transform.UpdateDeviceCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * DeviceController class
 * <p>
 *     - This class is a RestController that handles the requests for the devices.
 *     - This class has two endpoints, one for creating a device and another for updating a device.
 *     - This class uses the DeviceCommandService to handle the commands.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@RestController
@Tag(name = "Device Controller", description = "Endpoints for managing devices")
@ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "An error occurred with the server"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad request, you are missing some parameters"),
})

@RequestMapping(value = "api/v1/devices", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeviceController {

    private final DeviceCommandService deviceCommandService;

    public DeviceController(DeviceCommandService deviceCommandService) {
        this.deviceCommandService = deviceCommandService;
    }
    @PostMapping
    @Operation(summary = "Create a device")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Device created"),
    })
    public ResponseEntity<DeviceResource> createDevice(CreateDeviceResource createDeviceResource){
        var command = CreateDeviceCommandFromResourceAssembler.toCommandFromResource(createDeviceResource);
        var device = deviceCommandService.handle(command);
        var deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return new ResponseEntity<>(deviceResource, HttpStatus.CREATED);
    }

    @PutMapping("/{deviceId}")
    @Operation(summary = "Update a device")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Device updated"),
    })
    public ResponseEntity<DeviceResource> updateDevice(@PathVariable int deviceId, UpdateDeviceResource updateDeviceResource){
        var command = UpdateDeviceCommandFromResourceAssembler.toCommandFromResource(deviceId, updateDeviceResource);
        var device = deviceCommandService.handle(command);
        var deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return new ResponseEntity<>(deviceResource, HttpStatus.OK);
    }
}
