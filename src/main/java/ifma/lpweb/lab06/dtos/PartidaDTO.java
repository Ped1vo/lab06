package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Campeonato;
import ifma.lpweb.lab06.models.Estadio;
import ifma.lpweb.lab06.models.Resultados;
import ifma.lpweb.lab06.models.Time;

import lombok.Data;

import java.util.Date;

@Data
public class PartidaDTO {
    private Long id;
    private Date data;
    private Time timeMandante;
    private Time timeVisitante;
    private Campeonato campeonato;
    private Estadio estadio;
    private Resultados resultado;
}
