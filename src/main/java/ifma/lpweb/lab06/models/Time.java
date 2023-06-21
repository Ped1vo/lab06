package ifma.lpweb.lab06.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Time.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_time")
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Integer vitorias;

    private Integer saldoGols;

    @OneToMany(mappedBy="time")
    @JsonIgnore
    private List<Jogador> jogadores;

    @OneToMany(mappedBy = "timeMandante")
    @JsonIgnore
    private List<Partida> partidasMandante;

    @OneToMany(mappedBy = "timeVisitante")
    @JsonIgnore
    private List<Partida> partidasVisitante;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    @JsonIgnore
    private Campeonato campeonato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(Integer saldoGols) {
        this.saldoGols = saldoGols;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public List<Partida> getPartidasMandante() {
        return partidasMandante;
    }

    public void setPartidasMandante(List<Partida> partidasMandante) {
        this.partidasMandante = partidasMandante;
    }

    public List<Partida> getPartidasVisitante() {
        return partidasVisitante;
    }

    public void setPartidasVisitante(List<Partida> partidasVisitante) {
        this.partidasVisitante = partidasVisitante;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
}
