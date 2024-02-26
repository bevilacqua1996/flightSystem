package org.bevilacqua1996.flightsystem.domain.vo;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Iata {

    @Size.List({
            @Size(min = 3),
            @Size(max = 3)
    })
    String name;

    public Iata(String name) {
        this.name = name;
    }
}
