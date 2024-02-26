package org.bevilacqua1996.flightsystem.framework.output.rest.data;

import lombok.Data;

import java.util.List;

@Data
public class JsonObjectFlight {
    Object pagination;
    List<FlightDataDTO> data;
}
