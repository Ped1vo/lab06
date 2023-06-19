package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Partida;
import ifma.lpweb.lab06.models.Time;
import lombok.Data;

import java.util.List;

@Data
public class CampeonatoDTO {
    private Long id;
    private int ano;
    private String nome;
    private List<Partida> partidas;
    private List<Time> times;
}
