package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "tb_time")
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTime;
    @NotBlank
    private String nome;
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador;
    @OneToMany(mappedBy = "time")
    private List<Partida> partidas;
    @OneToOne(mappedBy = "time")
    private Estadio estadio;

}
