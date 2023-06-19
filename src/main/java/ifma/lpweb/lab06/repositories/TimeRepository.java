package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    Optional<Time> findById(Long idTime);

    Page<Time> findByNomeContaining(String nome, Pageable paginacao);

    List<Time> findByCampeonatoId(Long campeonatoId);
}
