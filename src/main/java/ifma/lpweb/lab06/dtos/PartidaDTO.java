package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Campeonato;
import ifma.lpweb.lab06.models.Time;

import java.time.LocalDate;

public record PartidaDTO(LocalDate data, Time time, Campeonato campeonato) {
}
