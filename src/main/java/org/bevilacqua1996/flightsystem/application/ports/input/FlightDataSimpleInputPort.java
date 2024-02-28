package org.bevilacqua1996.flightsystem.application.ports.input;

import feign.FeignException;
import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataOutputPort;
import org.bevilacqua1996.flightsystem.application.usecases.FlightDataSimpleUserCases;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.domain.service.FlightDataIncoming;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FlightDataSimpleInputPort implements FlightDataSimpleUserCases {

    @Autowired
    private FlightDataOutputPort outputRestAdapter;

    public void flightDataCheck(FlightData flightData) {
        FlightDataIncoming.checkConsistencyOfFlightData(flightData);
    }

    @Override
    public List<FlightData> fetchLastFlightData(Integer lastFlights) {
        List<FlightData> flightDataList = new ArrayList<>();
        try{
            outputRestAdapter.fetchLastFlightData(lastFlights).forEach(dto -> {
                flightDataList.add(dto.toFlightData());
            });
        } catch (FeignException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        return flightDataList;
    }

    @Override
    public void sendEventFlightData(FlightData flightData) {
        flightDataCheck(flightData);
        outputRestAdapter.persistFlightDataEvents(flightData);
    }
}
