package org.bevilacqua1996.flightsystem.domain.vo;

import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataOutputPort;
import org.bevilacqua1996.flightsystem.framework.output.rest.OutputRestKafkaAdapter;
import org.bevilacqua1996.flightsystem.framework.output.rest.OutputRestRedisAdapter;

public enum OutputAdapterEnum {
    FLIGHT_DATA_KAFKA("OutputRestKafkaAdapter", new OutputRestKafkaAdapter()),
    FLIGHT_DATA_REDIS("OutputRestRedisAdapter", new OutputRestRedisAdapter());

    private final String output;
    private final FlightDataOutputPort flightDataOutputPort;

    OutputAdapterEnum(String output, FlightDataOutputPort flightDataOutputPort) {
        this.output = output;
        this.flightDataOutputPort = flightDataOutputPort;
    }

    public String getOutput() {
        return output;
    }

    public FlightDataOutputPort getFlightDataOutputPort() {
        return flightDataOutputPort;
    }

    public static FlightDataOutputPort ofOutputString(String output) {
        for(OutputAdapterEnum outputAdapterEnum : OutputAdapterEnum.values()) {
            if(outputAdapterEnum.getOutput().equals(output)) {
                return outputAdapterEnum.flightDataOutputPort;
            }
        }
        throw new RuntimeException( "Output Adapter not found: " + output);
    }
}
