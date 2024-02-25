package org.bevilacqua1996.flightsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FlightSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSystemApplication.class, args);
	}

}
