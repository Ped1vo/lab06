package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Estadio;
import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Partida;

import java.util.List;

public record TimeDTO(String nome, List<Jogador> jogador, List<Partida> partidas, Estadio estadio) {
}
