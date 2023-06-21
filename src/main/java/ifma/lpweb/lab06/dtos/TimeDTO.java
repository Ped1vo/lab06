package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Campeonato;
import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Partida;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class TimeDTO {
    private Long id;
    @NotBlank(message = "O nome do time é obrigatório")
    private String nome;
    @NotBlank(message = "O endereço do time é obrigatório")
    private String endereco;
    private Integer vitorias;
    private Integer saldoGols;
    private Campeonato campeonato;
    private List<Jogador> jogadores;
    private List<Partida> partidasMandante;
    private List<Partida> partidasVisitante;

}
