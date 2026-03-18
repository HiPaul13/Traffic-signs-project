package com.hitzl.challenge.backend.validation;

import com.hitzl.challenge.backend.dto.ObservationDto;
import org.springframework.stereotype.Component;

@Component
public class ObservationValidator {

    public String validate(ObservationDto o) {
        if (o == null) return "Request body is missing";

        if (o.getLatitude() == null || o.getLongitude() == null)
            return "latitude and longitude are required";

        if (o.getType() == null)
            return "type is required";

        double lat = o.getLatitude();
        double lon = o.getLongitude();

        if (lat < -90 || lat > 90)
            return "latitude out of range (-90..90)";

        if (lon < -180 || lon > 180)
            return "longitude out of range (-180..180)";

        if (o.getHeading() != null) {
            int h = o.getHeading();
            if (h < 0 || h > 359)
                return "heading out of range (0..359)";
        }

        if (o.getType() != null && o.getType().name().equals("SPEED_LIMIT")) {
            if (o.getValue() == null || o.getValue().isBlank()) {
                return "value is required for SPEED_LIMIT";
            }
        }

        return null;
    }
}