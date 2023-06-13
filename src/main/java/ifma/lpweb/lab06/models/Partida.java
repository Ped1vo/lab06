package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPartida;
    private LocalDate data;
    @ManyToOne
    private Time time;
    @ManyToOne
    private Campeonato campeonato;

}
