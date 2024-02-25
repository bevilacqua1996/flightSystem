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
    private String aircraft;
    private String live;

    public FlightData(FlightDataID flightDataID, LocalDate flightDate, FlightStatus flightStatus, Departure departure, Arrival arrival, Airline airline, Flight flight, String aircraft, String live) {
        this.flightDataID = flightDataID;
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.departure = departure;
        this.arrival = arrival;
        this.airline = airline;
        this.flight = flight;
        this.aircraft = aircraft;
        this.live = live;
    }
}
