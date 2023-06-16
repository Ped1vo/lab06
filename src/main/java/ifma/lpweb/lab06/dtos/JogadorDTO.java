package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Time;
import lombok.Data;

@Data
public class JogadorDTO {
    private Long id;
    private String nome;
    private String dataNascimento;
    private String genero;
    private double altura;
    private Time time;
}
