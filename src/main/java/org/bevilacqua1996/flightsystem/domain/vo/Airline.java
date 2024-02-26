package org.bevilacqua1996.flightsystem.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Airline {

    private String name;
    private Iata iata;
    private Icao icao;
}
