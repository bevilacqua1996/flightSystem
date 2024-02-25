package org.bevilacqua1996.flightsystem.framework.output.rest.data;

import lombok.Getter;
import lombok.Setter;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.domain.entities.FlightDataBuilder;
import org.bevilacqua1996.flightsystem.domain.vo.*;

import java.time.LocalDate;

@Getter
@Setter
public class FlightDataDTO {
    private LocalDate flightDate;
    private FlightStatus flightStatus;
    private Departure departure;
    private Arrival arrival;
    private Airline airline;
    private Flight flight;
    private String aircraft;
    private String live;

    public FlightDataDTO(LocalDate flightDate, FlightStatus flightStatus, Departure departure, Arrival arrival, Airline airline, Flight flight, String aircraft, String live) {
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.departure = departure;
        this.arrival = arrival;
        this.airline = airline;
        this.flight = flight;
        this.aircraft = aircraft;
        this.live = live;
    }

    public FlightData toFlightData() {
        return new FlightDataBuilder()
                .setFlightDataID(FlightDataID.withoutId())
                .setFlight(this.getFlight())
                .setFlightDate(this.getFlightDate())
                .setFlightStatus(this.getFlightStatus())
                .setAircraft(this.getAircraft())
                .setAirline(this.getAirline())
                .setArrival(this.getArrival())
                .setDeparture(this.getDeparture())
                .createFlightData();
    }
}
