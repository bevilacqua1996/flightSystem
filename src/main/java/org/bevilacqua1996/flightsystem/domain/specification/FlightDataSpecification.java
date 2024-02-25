package org.bevilacqua1996.flightsystem.domain.specification;

import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.domain.specification.shared.Specification;

public class FlightDataSpecification implements Specification<FlightData> {
    @Override
    public boolean isSatisfiedBy(FlightData flightData) {
        return flightData != null && isFlightStagePresent(flightData) && isFlightAttributesPresent(flightData);
    }

    private boolean isFlightAttributesPresent(FlightData flightData) {
        return flightData.getAirline()!=null && flightData.getFlight()!=null;
    }

    private boolean isFlightStagePresent(FlightData flightData) {
        return flightData.getArrival()!=null && flightData.getDeparture()!=null;
    }
}
