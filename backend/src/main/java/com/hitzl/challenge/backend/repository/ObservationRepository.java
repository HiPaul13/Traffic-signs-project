package com.hitzl.challenge.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hitzl.challenge.backend.entity.ObservationEntity;

public interface ObservationRepository extends JpaRepository<ObservationEntity, Long> {
}

