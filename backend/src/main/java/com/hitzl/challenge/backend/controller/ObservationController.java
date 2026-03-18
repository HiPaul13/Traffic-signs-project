package com.hitzl.challenge.backend.controller;

import com.hitzl.challenge.backend.dto.ClusterDto;
import com.hitzl.challenge.backend.dto.ClusterNearbyDto;
import com.hitzl.challenge.backend.dto.ObservationDto;
import com.hitzl.challenge.backend.service.ObservationService;
import com.hitzl.challenge.backend.service.ClusterService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/observations")
public class ObservationController {

    private final ObservationService observationService;
    private final ClusterService clusterService;
    private static final Logger log = LoggerFactory.getLogger(ObservationController.class);

    public ObservationController(
            ObservationService observationService,
            ClusterService clusterService
    ) {
        this.observationService = observationService;
        this.clusterService = clusterService;
    }

    @PostMapping
    public ResponseEntity<Void> receiveObservation(@RequestBody ObservationDto observation) {
        observationService.saveObservation(observation);

        log.info("Received observation lat={}, lon={}, heading={}, type={}, value={}",
                observation.getLatitude(),
                observation.getLongitude(),
                observation.getHeading(),
                observation.getType(),
                observation.getValue()
        );

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/clusters")
    public List<ClusterDto> getClusters(@RequestParam(defaultValue = "30") double r) {
        return clusterService.getClusters(r);
    }

    @GetMapping("/clusters/nearby")
    public List<ClusterNearbyDto> getClustersNearby(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "200") double radius,
            @RequestParam(defaultValue = "30") double r
    ) {
        return clusterService.getClustersNearby(lat, lon, radius, r);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countObservations() {
        return ResponseEntity.ok(observationService.countObservations());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllObservations() {
        observationService.deleteAllObservations();
        return ResponseEntity.noContent().build();
    }
}