package org.bevilacqua1996.flightsystem.domain.service;

import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.domain.specification.FlightDataSpecification;

public class FlightDataIncoming {

    public static void checkConsistencyOfFlightData(FlightData flightData) {
        var flightDataSpec = new FlightDataSpecification();

        if(!flightDataSpec.isSatisfiedBy(flightData)) {
            throw new IllegalArgumentException("Not a valid FlightData incoming");
        }

    }

}
