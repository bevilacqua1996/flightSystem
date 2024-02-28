package org.bevilacqua1996.flightsystem.framework.output.rest;

import org.bevilacqua1996.flightsystem.framework.output.rest.data.FlightDataDTO;
import org.bevilacqua1996.flightsystem.framework.output.rest.feign.AviationStackInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public abstract class OutputRestAdapter {

    @Value("${aviation.stack.api.key}")
    private String apiKey;

    @Autowired
    private AviationStackInterface aviationStackInterface;

    public List<FlightDataDTO> fetchLastFlightData(Integer lastFlights) {
        return aviationStackInterface.getLastFlightData(apiKey, lastFlights).getData();
    }
}
