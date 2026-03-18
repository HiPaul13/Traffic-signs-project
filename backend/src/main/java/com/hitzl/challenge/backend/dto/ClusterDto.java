package com.hitzl.challenge.backend.dto;

import com.hitzl.challenge.backend.enums.SignType;

public class ClusterDto {
    private final double centerLat;
    private final double centerLon;
    private final SignType type;
    private final String value;
    private final int size;

    public ClusterDto(double centerLat, double centerLon, SignType type, String value, int size) {
        this.centerLat = centerLat;
        this.centerLon = centerLon;
        this.type = type;
        this.value = value;
        this.size = size;
    }

    public double getCenterLat() { return centerLat; }
    public double getCenterLon() { return centerLon; }
    public SignType getType() { return type; }
    public String getValue() { return value; }
    public int getSize() { return size; }
}

