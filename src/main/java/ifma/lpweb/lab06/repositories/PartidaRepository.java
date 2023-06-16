package ifma.lpweb.lab06.repositories;


import ifma.lpweb.lab06.models.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    Optional<Partida> findById(Long idPartida);


    Page<Partida> findByIdContaining(Long idPartida, Pageable paginacao);
}
