package org.bevilacqua1996.flightsystem.application.ports.input;

import org.bevilacqua1996.flightsystem.application.usecases.FlightDataUserCase;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.domain.service.FlightDataIncoming;
import org.bevilacqua1996.flightsystem.framework.output.rest.OutputRestAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightDataInputPort implements FlightDataUserCase {

    @Autowired
    private OutputRestAdapter outputRestAdapter;

    public void flightDataCheck(FlightData flightData) {
        FlightDataIncoming.checkConsistencyOfFlightData(flightData);
    }

    @Override
    public List<FlightData> fetchLastFlightData(Integer lastFlights) {
        List<FlightData> flightDataList = new ArrayList<>();
        outputRestAdapter.fetchLastFlightData(lastFlights).forEach(dto -> {
            flightDataList.add(dto.toFlightData());
        });
        return flightDataList;
    }

    @Override
    public void sendEventFlightData(FlightData flightData) {
        flightDataCheck(flightData);
        outputRestAdapter.sendFlightDataEvents(flightData);
    }
}
