package org.bevilacqua1996.flightsystem.framework.output.rest.data.redis.entities;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("FlightData")
public class FlightDataCache implements Serializable {

    private String id;
    private String departure;
    private String arrival;
    private String flightDate;

}
