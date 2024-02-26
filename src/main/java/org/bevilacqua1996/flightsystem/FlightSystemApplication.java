package org.bevilacqua1996.flightsystem;

import org.bevilacqua1996.flightsystem.application.ports.output.FlightDataOutputPort;
import org.bevilacqua1996.flightsystem.application.usecases.FlightDataUserCase;
import org.bevilacqua1996.flightsystem.domain.vo.InputPortEnum;
import org.bevilacqua1996.flightsystem.domain.vo.OutputAdapterEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FlightSystemApplication {

	@Value("${input.port}")
	String inputPort;

	@Value("${output.adapter}")
	String outputAdapter;

	public static void main(String[] args) {
		SpringApplication.run(FlightSystemApplication.class, args);
	}

	@Bean
	public FlightDataUserCase flightDataUserCase() {
		return InputPortEnum.ofInputString(inputPort);
	}

	@Bean
	public FlightDataOutputPort flightDataOutputPort() {
		return OutputAdapterEnum.ofOutputString(outputAdapter);
	}

}
