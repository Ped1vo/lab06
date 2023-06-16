package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "tb_partida")
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "time_mandante_id")
    private Time timeMandante;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private Time timeVisitante;

    @ManyToOne
    @JoinColumn(name ="campeonato_id")
    private Campeonato campeonato;

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    @OneToOne(mappedBy = "partida", cascade = CascadeType.ALL)
    private Resultados resultado;
}
