package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    Optional<Partida> findById(Long idPartida);


    Page<Partida> findByIdContaining(Long idPartida, Pageable paginacao);

    @Query("SELECT p FROM Partida p WHERE p.campeonato.id = :campeonatoId AND p.data < CURRENT_TIMESTAMP ORDER BY p.data DESC")
    List<Partida> findPartidaOcorridaByCampeonatoId(@Param("campeonatoId") Long campeonatoId);

    @Query("SELECT p FROM Partida p WHERE p.campeonato.id = :campeonatoId AND p.data >= CURRENT_TIMESTAMP")
    List<Partida> findPartidasNaoOcorridasByCampeonatoId(@Param("campeonatoId") Long campeonatoId);
}
