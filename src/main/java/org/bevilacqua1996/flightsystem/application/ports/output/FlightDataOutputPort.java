package org.bevilacqua1996.flightsystem.application.ports.output;

import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.FlightDataDTO;

import java.util.List;

public interface FlightDataOutputPort {

    List<FlightDataDTO> fetchLastFlightData(Integer lastFlights);

    void sendFlightDataEvents(FlightData flightData);

}
