package org.bevilacqua1996.flightsystem.domain.vo;

import lombok.Data;

@Data
public abstract class FlightStage {
    String airport;
    String timezone;
    Iata iata;
    Icao icao;
    String terminal;
}
