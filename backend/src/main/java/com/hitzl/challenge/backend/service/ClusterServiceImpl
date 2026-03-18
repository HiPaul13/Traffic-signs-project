package com.hitzl.challenge.backend.service;

import com.hitzl.challenge.backend.dto.ClusterDto;
import com.hitzl.challenge.backend.dto.ClusterNearbyDto;
import com.hitzl.challenge.backend.dto.ObservationDto;
import com.hitzl.challenge.backend.logic.Cluster;
import com.hitzl.challenge.backend.logic.ClusterLogic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClusterServiceImpl implements ClusterService {

    private final ObservationService observationService;

    public ClusterServiceImpl(ObservationService observationService) {
        this.observationService = observationService;
    }

    @Override
    public List<ClusterDto> getClusters(double r) {
        List<ObservationDto> observations = observationService.getAllObservations();

        ClusterLogic logic = new ClusterLogic(r);
        List<Cluster> clusters = logic.cluster(observations);

        return clusters.stream()
                .map(c -> new ClusterDto(
                        c.getCenterLat(),
                        c.getCenterLon(),
                        c.getType(),
                        c.getValue(),
                        c.size()
                ))
                .toList();
    }

    @Override
    public List<ClusterNearbyDto> getClustersNearby(double lat, double lon, double radius, double r) {
        List<ObservationDto> observations = observationService.getAllObservations();

        return new ClusterLogic(r)
                .clusterNearby(observations, r, lat, lon, radius);
    }
}