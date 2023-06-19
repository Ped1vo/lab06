package ifma.lpweb.lab06.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_jogador")
public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String dataNascimento;
    @NotBlank
    private String genero;
    @NotNull
    private double altura;

    @ManyToOne
    @JoinColumn(name ="time_id")
    private Time time;

}
