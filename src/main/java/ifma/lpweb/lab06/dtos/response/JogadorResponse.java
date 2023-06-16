package ifma.lpweb.lab06.dtos.response;

import lombok.Data;


import java.util.UUID;

@Data
public class JogadorResponse {
    private Long id;
    private String nome;
    private String nascimento;
    private String genero;
    private double altura;
    private String time;

}
