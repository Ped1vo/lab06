package ifma.lpweb.lab06.dtos.input;

import ifma.lpweb.lab06.models.Partida;

import java.util.List;

public record CampeonatoDTO(int ano, String nome, List<Partida> partidas) {
}
