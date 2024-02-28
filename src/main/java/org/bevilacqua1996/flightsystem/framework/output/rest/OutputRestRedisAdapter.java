package org.bevilacqua1996.flightsystem.framework.output.rest;

import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataInternalFetchOutputPort;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.FlightDataDTO;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.entities.FlightDataCache;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.repository.FlightDataCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OutputRestRedisAdapter extends OutputRestAdapter implements FlightDataInternalFetchOutputPort {

    @Autowired
    private FlightDataCacheRepository flightDataCacheRepository;

    @Override
    public List<FlightDataDTO> fetchLastFlightData(Integer lastFlights) {
        return super.fetchLastFlightData(lastFlights);
    }

    @Override
    public void persistFlightDataEvents(FlightData flightData) {

        FlightDataCache flightDataCache = new FlightDataCache();
        flightDataCache.setId(flightData.getFlightDataID().toString());
        flightDataCache.setDeparture(flightData.getDeparture().getIcao().getName());
        flightDataCache.setArrival(flightData.getArrival().getIcao().getName());
        flightDataCache.setFlightDate(flightData.getFlightDate().toString());

        flightDataCacheRepository.save(flightDataCache);

    }

    @Override
    public List<FlightDataCache> fetchCache() {
        List<FlightDataCache> response = new ArrayList<>();
        flightDataCacheRepository.findAll().forEach(response::add);
        return response;
    }
}
