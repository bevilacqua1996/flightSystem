package org.bevilacqua1996.flightsystem.application.usecases;

import org.bevilacqua1996.flightsystem.domain.entities.FlightData;

import java.util.List;

public interface FlightDataSimpleUserCases {

    List<FlightData> fetchLastFlightData(Integer lastFlights);
    void sendEventFlightData(FlightData flightData);

}
