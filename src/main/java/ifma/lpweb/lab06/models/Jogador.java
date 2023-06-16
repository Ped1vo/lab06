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
@Table(name = "tb_jogador")
public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String dataNascimento;

    private String genero;

    private double altura;

    @ManyToOne
    @JoinColumn(name ="time_id")
    private Time time;

}
