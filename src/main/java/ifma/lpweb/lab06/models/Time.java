package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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
    private Long id;

    private String nome;

    private int vitorias;

    private int saldoGols;

    @OneToMany(mappedBy="time")
    private List<Jogador> jogadores;

    @OneToMany(mappedBy="time")
    private List<Partida> partidas;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

}
