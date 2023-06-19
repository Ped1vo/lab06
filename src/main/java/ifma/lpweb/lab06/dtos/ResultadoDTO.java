package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Partida;

import lombok.Data;

@Data
public class ResultadoDTO {
    private Long id;
    private int golsTimeMandante;
    private int golsTimeVisitante;
    private Partida partida;
}
