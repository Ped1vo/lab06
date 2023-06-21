package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Partida;

import lombok.Data;

@Data
public class ResultadoDTO {
    private Long id;
    private Integer golsTimeMandante;
    private Integer golsTimeVisitante;
    private Partida partida;
}
