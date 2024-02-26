package org.bevilacqua1996.flightsystem.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Flight {

    private String number;
    private Iata iata;
    private Icao icao;
}
