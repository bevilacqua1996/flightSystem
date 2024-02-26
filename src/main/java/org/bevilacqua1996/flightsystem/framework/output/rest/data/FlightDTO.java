package org.bevilacqua1996.flightsystem.framework.output.rest.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class FlightDTO {
    private String number;
    private String iata;
    private String icao;
}
