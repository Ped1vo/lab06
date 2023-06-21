package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Campeonato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
    Optional<Campeonato> findById(Long campeonatoId);


}
