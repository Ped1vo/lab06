package ifma.lpweb.lab06.dtos.request;

import ifma.lpweb.lab06.models.Time;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class JogadorRequest {
    @NotBlank(message = "O nome do jogador é obrigatório")
    private String nome;
    @NotBlank(message = "A data de nascimento do jogador é obrigatória")
    private String dataNascimento;
    @NotBlank(message = "O genero do jogador é obrigatório")
    private String genero;
    @NotNull(message = "A altura do jogador é obrigatória")
    private double altura;
    private Time time;

}
