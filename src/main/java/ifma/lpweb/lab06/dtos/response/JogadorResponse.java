package ifma.lpweb.lab06.dtos.response;

import ifma.lpweb.lab06.models.Time;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Data
@Getter
@Setter
public class JogadorResponse {
    private Long idJogador;
    private String nome;
    private String dataNascimento;
    private String genero;
    private double altura;
    private Time time;

}
