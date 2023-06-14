package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_time")
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTime;
    private String nome;
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador;
    @OneToMany(mappedBy = "time")
    private List<Partida> partidas;
    @OneToOne
    private Estadio estadio;

}
