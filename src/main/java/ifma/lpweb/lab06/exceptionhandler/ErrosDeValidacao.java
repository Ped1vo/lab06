package ifma.lpweb.lab06.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrosDeValidacao {
    private LocalDateTime dataHora;
    private String titulo;
    private List<Erro> erros = new ArrayList<>();

    public ErrosDeValidacao(LocalDateTime dataHora, String titulo) {
        this.dataHora = dataHora;
        this.titulo = titulo;
    }
    public void adiciona(Erro erro){
        erros.add(erro);
    }
}
