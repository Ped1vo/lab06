package ifma.lpweb.lab06.dtos.input;

import ifma.lpweb.lab06.models.Time;

import java.time.LocalDate;

public record JogadorDTO(String nome, LocalDate nascimento, String genero, double altura, Time time) {
}
