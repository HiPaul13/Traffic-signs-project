package com.hitzl.challenge.backend.service;

import com.hitzl.challenge.backend.dto.ClusterDto;
import com.hitzl.challenge.backend.dto.ClusterNearbyDto;

import java.util.List;


public interface ClusterService {
    
    List<ClusterDto> getClusters(double r);
    List<ClusterNearbyDto> getClustersNearby(double lat, double lon, double radius, double r);
}