package ifma.lpweb.lab06.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class JogadorRequest {
    @NotNull
    private Long idJogador;

}
