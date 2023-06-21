package ifma.lpweb.lab06.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Resultados.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Resultados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer golsTimeMandante;
    private Integer golsTimeVisitante;

    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGolsTimeMandante() {
        return golsTimeMandante;
    }

    public void setGolsTimeMandante(Integer golsTimeMandante) {
        this.golsTimeMandante = golsTimeMandante;
    }

    public Integer getGolsTimeVisitante() {
        return golsTimeVisitante;
    }

    public void setGolsTimeVisitante(Integer golsTimeVisitante) {
        this.golsTimeVisitante = golsTimeVisitante;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
