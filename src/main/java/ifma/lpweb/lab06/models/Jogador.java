package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_jogador")
public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJogador;
    @NotBlank @Size(min = 3, max = 50)
    private String nome;
    @NotNull
    private LocalDate nascimento;
    @NotNull
    private String genero;
    @NotNull
    private Double altura;
    @ManyToOne
    private Time time;

    public String getNascimentoFormatted() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return nascimento.format(formato);
    }

}
