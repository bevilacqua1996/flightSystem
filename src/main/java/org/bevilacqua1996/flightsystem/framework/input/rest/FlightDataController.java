package org.bevilacqua1996.flightsystem.framework.input.rest;

import org.bevilacqua1996.flightsystem.application.ports.input.FlightDataInputPort;
import org.bevilacqua1996.flightsystem.application.usecases.FlightDataUserCase;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flightdata")
public class FlightDataController {

    @Autowired
    private FlightDataUserCase flightDataInputPort;

    @GetMapping(value = "/last/{quantity}", produces = "application/json")
    public ResponseEntity<List<FlightData>> getLastFlightData(@PathVariable Integer quantity) {
        List<FlightData> flightDataList = flightDataInputPort.fetchLastFlightData(quantity);
        return ResponseEntity.ok(flightDataList);
    }

    @PostMapping(value = "/last/{quantity}", produces = "application/json")
    public ResponseEntity<Void> sendEventLastFlightData(@PathVariable Integer quantity) {
        List<FlightData> flightDataList = flightDataInputPort.fetchLastFlightData(quantity);
        flightDataList.forEach(fd -> {
            try {
                flightDataInputPort.sendEventFlightData(fd);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        });
        return ResponseEntity.ok().build();
    }

}
