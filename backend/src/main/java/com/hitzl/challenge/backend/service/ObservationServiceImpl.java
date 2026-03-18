package com.hitzl.challenge.backend.service;

import com.hitzl.challenge.backend.dto.ObservationDto;
import com.hitzl.challenge.backend.entity.ObservationEntity;
import com.hitzl.challenge.backend.mapper.ObservationMapper;
import com.hitzl.challenge.backend.repository.ObservationRepository;
import com.hitzl.challenge.backend.validation.ObservationValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import com.hitzl.challenge.backend.exception.InvalidObservationException;

@Service
public class ObservationServiceImpl implements ObservationService {

    private final ObservationRepository repo;
    private final ObservationMapper mapper;
    private final ObservationValidator validator;

    public ObservationServiceImpl(
            ObservationRepository repo,
            ObservationMapper mapper,
            ObservationValidator validator
    ) {
        this.repo = repo;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public void saveObservation(ObservationDto observation) {
        String error = validator.validate(observation);
        if (error != null) {
            throw new InvalidObservationException(error);
        }

        ObservationEntity entity = mapper.toEntity(observation);
        repo.save(entity);
    }

    @Override
    public List<ObservationDto> getAllObservations() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public long countObservations() {
        return repo.count();
    }

    @Override
    public void deleteAllObservations() {
        repo.deleteAll();
    }
}