package ifma.lpweb.lab06.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_estadio")
public class Estadio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstadio;
    @NotBlank @Size(min = 3, max = 50)
    private String nome;
    @NotBlank
    private String endereco;

}
