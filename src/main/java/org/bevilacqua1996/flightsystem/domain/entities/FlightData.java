package org.bevilacqua1996.flightsystem.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.bevilacqua1996.flightsystem.domain.vo.*;

import java.time.LocalDate;


@Setter
@Getter
public class FlightData {
    private FlightDataID flightDataID;
    private LocalDate flightDate;
    private FlightStatus flightStatus;
    private Departure departure;
    private Arrival arrival;
    private Airline airline;
    private Flight flight;

    public FlightData(FlightDataID flightDataID, LocalDate flightDate, FlightStatus flightStatus, Departure departure, Arrival arrival, Airline airline, Flight flight) {
        this.flightDataID = flightDataID;
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.departure = departure;
        this.arrival = arrival;
        this.airline = airline;
        this.flight = flight;
    }
}
