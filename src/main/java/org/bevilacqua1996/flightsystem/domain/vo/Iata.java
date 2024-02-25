package org.bevilacqua1996.flightsystem.domain.vo;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Iata {

    @Size.List({
            @Size(min = 3),
            @Size(max = 3)
    })
    String name;
}
