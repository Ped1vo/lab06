package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Partida;
import lombok.Data;

import java.util.List;

@Data
public class TimeDTO {
    private Long id;
    private String nome;
    private String endereco;
    private List<Jogador> jogadores;
    private List<Partida> partidasMandante;
    private List<Partida> partidasVisitante;
}
