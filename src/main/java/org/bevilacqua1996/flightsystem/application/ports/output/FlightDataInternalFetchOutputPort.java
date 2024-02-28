package org.bevilacqua1996.flightsystem.application.ports.output;

import org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.entities.FlightDataCache;

import java.util.List;

public interface FlightDataInternalFetchOutputPort extends FlightDataOutputPort {
    List<FlightDataCache> fetchCache();
}
