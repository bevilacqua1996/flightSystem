package org.bevilacqua1996.flightsystem.domain.entities;

import org.bevilacqua1996.flightsystem.domain.vo.*;

import java.time.LocalDate;

public class FlightDataBuilder {
    private FlightDataID flightDataID;
    private LocalDate flightDate;
    private FlightStatus flightStatus;
    private Departure departure;
    private Arrival arrival;
    private Airline airline;
    private Flight flight;
    private String aircraft;
    private String live;

    public FlightDataBuilder setFlightDataID(FlightDataID flightDataID) {
        this.flightDataID = flightDataID;
        return this;
    }

    public FlightDataBuilder setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
        return this;
    }

    public FlightDataBuilder setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
        return this;
    }

    public FlightDataBuilder setDeparture(Departure departure) {
        this.departure = departure;
        return this;
    }

    public FlightDataBuilder setArrival(Arrival arrival) {
        this.arrival = arrival;
        return this;
    }

    public FlightDataBuilder setAirline(Airline airline) {
        this.airline = airline;
        return this;
    }

    public FlightDataBuilder setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }

    public FlightDataBuilder setAircraft(String aircraft) {
        this.aircraft = aircraft;
        return this;
    }

    public FlightDataBuilder setLive(String live) {
        this.live = live;
        return this;
    }

    public FlightData createFlightData() {
        return new FlightData(flightDataID, flightDate, flightStatus, departure, arrival, airline, flight, aircraft, live);
    }
}