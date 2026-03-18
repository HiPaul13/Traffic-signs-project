package com.hitzl.challenge.backend.service;

import com.hitzl.challenge.backend.dto.ObservationDto;

import java.util.List;

public interface ObservationService {
    void saveObservation(ObservationDto observation);
    List<ObservationDto> getAllObservations();
    long countObservations();
    void deleteAllObservations();
}