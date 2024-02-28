package org.bevilacqua1996.flightsystem.application.usecases;

import org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.entities.FlightDataCache;

import java.util.List;

public interface FlightDataInternalFetchUserCases extends FlightDataSimpleUserCases {
    List<FlightDataCache> fetchFlightDataCache();
}
