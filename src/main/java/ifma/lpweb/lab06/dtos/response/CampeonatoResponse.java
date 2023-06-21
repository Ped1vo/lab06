package ifma.lpweb.lab06.dtos.response;

import ifma.lpweb.lab06.models.Partida;
import ifma.lpweb.lab06.models.Time;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CampeonatoResponse {
    private Long idCampeonato;
    private Integer ano;
    private String nome;
    private List<Partida> partidas;
    private List<Time> times;
}
