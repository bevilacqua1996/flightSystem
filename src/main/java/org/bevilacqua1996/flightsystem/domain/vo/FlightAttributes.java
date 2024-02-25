package org.bevilacqua1996.flightsystem.domain.vo;

import lombok.Data;

@Data
public abstract class FlightAttributes {
    private String name;
    private Iata iata;
    private Icao icao;
}
