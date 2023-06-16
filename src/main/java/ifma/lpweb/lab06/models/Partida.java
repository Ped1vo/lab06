package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

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
    private Long idPartida;
    @PastOrPresent
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Time time;
    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

}
