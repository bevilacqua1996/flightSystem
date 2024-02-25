package org.bevilacqua1996.flightsystem.framework.output.rest;

import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataOutputPort;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.FlightDataDTO;
import org.bevilacqua1996.flightsystem.framework.output.rest.feign.AviationStackInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OutputRestAdapter implements FlightDataOutputPort {

    @Value("${aviation.stack.api.key}")
    private String apiKey;

    @Autowired
    private AviationStackInterface aviationStackInterface;

    @Override
    public List<FlightDataDTO> fetchLastFlightData(Integer lastFlights) {
        return aviationStackInterface.getLastFlightData(apiKey, lastFlights);
    }

    @Override
    public void sendFlightDataEvents(FlightData flightData) {

    }
}
