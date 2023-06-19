package ifma.lpweb.lab06.dtos.response;

import lombok.Data;


import java.util.UUID;

@Data
public class JogadorResponse {
    private Long idJogador;
    private String nome;
    private String dataNascimento;
    private String genero;
    private double altura;
    private String time;

}
