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
@Table(name = "tb_estadio")
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEstadio;
    private String nome;
    private String endereco;
    @OneToOne
    private Time time;

}
