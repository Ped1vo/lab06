package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Partida;
import ifma.lpweb.lab06.models.Time;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CampeonatoDTO {
    private Long id;
    @NotNull(message = "O ano do campeonato é obrigatório")
    private Integer ano;
    @NotBlank(message = "O nome do campeonato é obrigatório")
    private String nome;
    private List<Partida> partidas;
    private List<Time> times;
}
