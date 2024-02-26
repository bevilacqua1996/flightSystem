package org.bevilacqua1996.flightsystem.framework.output.rest.data;

import lombok.Data;
import org.bevilacqua1996.flightsystem.domain.vo.Iata;
import org.bevilacqua1996.flightsystem.domain.vo.Icao;

@Data
public abstract class FlightStageDTO {

    String airport;
    String timezone;
    String iata;
    String icao;
    String terminal;
}
