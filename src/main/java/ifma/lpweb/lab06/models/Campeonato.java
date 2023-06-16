package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_campeonato")
public class Campeonato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int ano;

    private String nome;

    @OneToMany(mappedBy="campeonato")
    private List<Partida> partidas;

    @OneToMany(mappedBy="campeonato")
    private List<Time> times;

}
