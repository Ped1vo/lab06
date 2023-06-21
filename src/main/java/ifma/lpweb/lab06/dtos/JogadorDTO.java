package ifma.lpweb.lab06.dtos;

import ifma.lpweb.lab06.models.Time;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JogadorDTO {
    private Long id;
    @NotBlank(message = "O nome do jogador é obrigatório")
    private String nome;
    @NotBlank(message = "A data de nascimento do jogador é obrigatória")
    private String dataNascimento;
    @NotBlank(message = "O genero do jogador é obrigatório")
    private String genero;
    @NotNull(message = "A altura do jogador é obrigatória")
    private double altura;
    @NotNull(message = "O peso do jogador é obrigatório")
    private Time time;
}
