package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_campeonato")
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCampeonato;
    private int ano;
    private String nome;
    @OneToMany(mappedBy = "campeonato")
    private List<Partida> partidas;
}
