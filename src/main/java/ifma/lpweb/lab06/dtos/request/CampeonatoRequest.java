package ifma.lpweb.lab06.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class CampeonatoRequest {
    @NotNull(message = "O ano do campeonato é obrigatório")
    private Integer ano;
    @NotBlank(message = "O nome do campeonato é obrigatório")
    private String nome;
}
