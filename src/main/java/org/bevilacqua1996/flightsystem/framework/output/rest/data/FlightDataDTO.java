package org.bevilacqua1996.flightsystem.framework.output.rest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.bevilacqua1996.flightsystem.domain.entities.FlightData;
import org.bevilacqua1996.flightsystem.domain.entities.FlightDataBuilder;
import org.bevilacqua1996.flightsystem.domain.policy.DateFormatter;
import org.bevilacqua1996.flightsystem.domain.vo.*;

import java.util.Optional;

@Getter
@Setter
public class FlightDataDTO {
    @JsonProperty("flight_date")
    private String flightDate;
    @JsonProperty("flight_status")
    private String flightStatus;
    private DepartureDTO departure;
    private ArrivalDTO arrival;
    private AirlineDTO airline;
    private FlightDTO flight;

    public FlightDataDTO(String flightDate, String flightStatus, DepartureDTO departure, ArrivalDTO arrival, AirlineDTO airline, FlightDTO flight) {
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.departure = departure;
        this.arrival = arrival;
        this.airline = airline;
        this.flight = flight;
    }

    public FlightData toFlightData() {
        Departure departure = new Departure();
        departure.setIata(new Iata(this.getDeparture().getIata()));
        departure.setIcao(new Icao(this.getDeparture().getIcao()));
        departure.setAirport(this.getDeparture().getAirport());
        departure.setTimezone(this.getDeparture().getTimezone());
        departure.setTerminal(this.getDeparture().getTerminal());

        Arrival arrival = new Arrival();
        arrival.setIata(new Iata(this.getArrival().getIata()));
        arrival.setIcao(new Icao(this.getArrival().getIcao()));
        arrival.setAirport(this.getArrival().getAirport());
        arrival.setTimezone(this.getArrival().getTimezone());
        arrival.setTerminal(this.getArrival().getTerminal());

        Airline airline = new Airline();
        airline.setIata(new Iata(this.getAirline().getIata()));
        airline.setIcao(new Icao(this.getAirline().getIata()));
        airline.setName(this.getAirline().getName());

        Flight flight = new Flight();
        flight.setIata(new Iata(this.getFlight().getIata()));
        flight.setIcao(new Icao(this.getFlight().getIata()));
        flight.setNumber(this.getFlight().getNumber());

        DateFormatter dateFormatter = new DateFormatter();

        return new FlightDataBuilder()
                .setFlightDataID(FlightDataID.withoutId())
                .setFlight(flight)
                .setFlightDate(dateFormatter.parseDate(this.getFlightDate()))
                .setFlightStatus(this.flightStatus == null ? FlightStatus.DIVERTED : FlightStatus.ofStatus(this.flightStatus))
                .setAirline(airline)
                .setArrival(arrival)
                .setDeparture(departure)
                .createFlightData();
    }
}
