package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Resultados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int golsTimeMandante;
    private int golsTimeVisitante;

    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;


}
