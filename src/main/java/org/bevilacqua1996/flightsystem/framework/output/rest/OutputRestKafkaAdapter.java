package org.bevilacqua1996.flightsystem.framework.output.rest;

import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataOutputPort;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.FlightDataDTO;
import org.bevilacqua1996.flightsystem.framework.output.rest.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

public class OutputRestKafkaAdapter extends OutputRestAdapter implements FlightDataOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public List<FlightDataDTO> fetchLastFlightData(Integer lastFlights) {
        return super.fetchLastFlightData(lastFlights);
    }

    @Override
    public void persistFlightDataEvents(FlightData flightData) {
        String event = getEventToSend(flightData);
        kafkaTemplate.send(Constants.FLIGHT_SYSTEM_TOPIC, event);
    }

    private String getEventToSend(FlightData flightData) {
        return flightData.getFlightDataID() + ": From -> "
                + flightData.getDeparture().getIcao()
                + " To -> " + flightData.getArrival().getIcao()
                + " Date: " + flightData.getFlightDate();
    }
}
