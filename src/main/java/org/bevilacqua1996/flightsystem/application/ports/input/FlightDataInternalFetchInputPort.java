package org.bevilacqua1996.flightsystem.application.ports.input;

import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataInternalFetchOutputPort;
import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataOutputPort;
import org.bevilacqua1996.flightsystem.application.usecases.FlightDataInternalFetchUserCases;
import org.bevilacqua1996.flightsystem.framework.input.rest.exception.UnavailablePortException;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.entities.FlightDataCache;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlightDataInternalFetchInputPort extends FlightDataSimpleInputPort implements FlightDataInternalFetchUserCases {

    @Autowired
    private FlightDataOutputPort outputRestAdapter;

    @Override
    public List<FlightDataCache> fetchFlightDataCache() {
        try {
            FlightDataInternalFetchOutputPort outputRestInternalFetchAdapter = (FlightDataInternalFetchOutputPort) outputRestAdapter;
            return outputRestInternalFetchAdapter.fetchCache();
        } catch (Exception e) {
            throw new UnavailablePortException("Invalid Operation for this output adapter");
        }
    }
}
