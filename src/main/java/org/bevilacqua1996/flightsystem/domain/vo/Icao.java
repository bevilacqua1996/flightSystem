package org.bevilacqua1996.flightsystem.domain.vo;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Icao {
    @Size.List({
            @Size(min = 4),
            @Size(max = 4)
    })
    String name;

    public Icao(String name) {
        this.name = name;
    }
}
