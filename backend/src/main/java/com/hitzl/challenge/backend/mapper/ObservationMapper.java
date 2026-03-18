package com.hitzl.challenge.backend.mapper;

import com.hitzl.challenge.backend.dto.ObservationDto;
import com.hitzl.challenge.backend.entity.ObservationEntity;
import org.springframework.stereotype.Component;

@Component
public class ObservationMapper {

    public ObservationEntity toEntity(ObservationDto dto) {
        ObservationEntity e = new ObservationEntity();
        e.setLatitude(dto.getLatitude());
        e.setLongitude(dto.getLongitude());
        e.setHeading(dto.getHeading());
        e.setType(dto.getType());
        e.setValue(dto.getValue());
        return e;
    }

    public ObservationDto toDto(ObservationEntity e) {
        ObservationDto dto = new ObservationDto();
        dto.setLatitude(e.getLatitude());
        dto.setLongitude(e.getLongitude());
        dto.setHeading(e.getHeading());
        dto.setType(e.getType());
        dto.setValue(e.getValue());
        return dto;
    }
}