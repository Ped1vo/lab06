package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    Optional<Jogador> findById(Long idJogador);

    @Override
    @EntityGraph(attributePaths = {"time"})
    List<Jogador> findAll();

    Page<Jogador> findByNomeContaining(String nome, Pageable paginacao);
}
