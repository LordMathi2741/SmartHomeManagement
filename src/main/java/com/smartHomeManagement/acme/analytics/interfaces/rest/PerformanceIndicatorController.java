package com.smartHomeManagement.acme.analytics.interfaces.rest;

import com.smartHomeManagement.acme.analytics.domain.services.PerformanceIndicatorCommandService;
import com.smartHomeManagement.acme.analytics.interfaces.rest.resources.CreatePerformanceIndicatorResource;
import com.smartHomeManagement.acme.analytics.interfaces.rest.resources.PerformanceIndicatorResource;
import com.smartHomeManagement.acme.analytics.interfaces.rest.transform.CreatePerformanceIndicatorCommandFromResourceAssembler;
import com.smartHomeManagement.acme.analytics.interfaces.rest.transform.PerformanceIndicatorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PerformanceIndicatorController
 * <p>
 *     This class is responsible for handling the REST API requests related to performance indicators.
 * </p>
 * @author U20221721 Mathias Jave Diaz
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/performance-indicators", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "PerformanceIndicator Controller", description = "Operations related to performance indicators")
@ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad request"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
})
public class PerformanceIndicatorController {

    private final PerformanceIndicatorCommandService performanceIndicatorCommandService;

    public PerformanceIndicatorController(PerformanceIndicatorCommandService performanceIndicatorCommandService) {
        this.performanceIndicatorCommandService = performanceIndicatorCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a performance indicator")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Performance indicator created")
    })
    public ResponseEntity<PerformanceIndicatorResource> createPerformanceIndicator(@RequestBody CreatePerformanceIndicatorResource createPerformanceIndicatorResource) {
        var command = CreatePerformanceIndicatorCommandFromResourceAssembler.toCommandFromResource(createPerformanceIndicatorResource);
        var performanceIndicator = performanceIndicatorCommandService.handle(command);
        var performanceIndicatorResource = PerformanceIndicatorResourceFromEntityAssembler.toResourceFromEntity(performanceIndicator.get());
        return new ResponseEntity<>(performanceIndicatorResource, HttpStatus.CREATED);
    }
}
