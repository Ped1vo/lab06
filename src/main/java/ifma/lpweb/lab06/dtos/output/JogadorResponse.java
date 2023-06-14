package ifma.lpweb.lab06.dtos.output;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class JogadorResponse {
    private UUID idJogador;
    private String nome;
    private String nascimento;
    private String genero;
    private double altura;
    private String time;

}
