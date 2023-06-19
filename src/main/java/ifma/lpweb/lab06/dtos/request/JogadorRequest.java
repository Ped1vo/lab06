package ifma.lpweb.lab06.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public class JogadorRequest {
    @NotNull
    private Long idJogador;

}
