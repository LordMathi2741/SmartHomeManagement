package com.smartHomeManagement.acme.analytics.interfaces.rest;

import com.smartHomeManagement.acme.analytics.domain.services.PerformanceIndicatorCommandService;
import com.smartHomeManagement.acme.analytics.interfaces.rest.resources.CreatePerformanceIndicatorResource;
import com.smartHomeManagement.acme.analytics.interfaces.rest.resources.PerformanceIndicatorResource;
import com.smartHomeManagement.acme.analytics.interfaces.rest.transform.CreatePerformanceIndicatorCommandFromResourceAssembler;
import com.smartHomeManagement.acme.analytics.interfaces.rest.transform.PerformanceIndicatorResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/performance-indicators", produces = MediaType.APPLICATION_JSON_VALUE)
public class PerformanceIndicatorController {

    private final PerformanceIndicatorCommandService performanceIndicatorCommandService;

    public PerformanceIndicatorController(PerformanceIndicatorCommandService performanceIndicatorCommandService) {
        this.performanceIndicatorCommandService = performanceIndicatorCommandService;
    }

    @PostMapping
    public ResponseEntity<PerformanceIndicatorResource> createPerformanceIndicator(@RequestBody CreatePerformanceIndicatorResource createPerformanceIndicatorResource) {
        var command = CreatePerformanceIndicatorCommandFromResourceAssembler.toCommandFromResource(createPerformanceIndicatorResource);
        var performanceIndicator = performanceIndicatorCommandService.handle(command);
        var performanceIndicatorResource = PerformanceIndicatorResourceFromEntityAssembler.toResourceFromEntity(performanceIndicator.get());
        return new ResponseEntity<>(performanceIndicatorResource, HttpStatus.CREATED);
    }
}
