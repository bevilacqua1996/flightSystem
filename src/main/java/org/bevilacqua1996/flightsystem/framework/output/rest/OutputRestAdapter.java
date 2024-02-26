package org.bevilacqua1996.flightsystem.framework.output.rest;

import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataOutputPort;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.framework.output.rest.data.FlightDataDTO;
import org.bevilacqua1996.flightsystem.framework.output.rest.feign.AviationStackInterface;
import org.bevilacqua1996.flightsystem.framework.output.rest.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

public class OutputRestAdapter implements FlightDataOutputPort {

    @Value("${aviation.stack.api.key}")
    private String apiKey;

    @Autowired
    private AviationStackInterface aviationStackInterface;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public List<FlightDataDTO> fetchLastFlightData(Integer lastFlights) {
        return aviationStackInterface.getLastFlightData(apiKey, lastFlights).getData();
    }

    @Override
    public void sendFlightDataEvents(FlightData flightData) {
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
