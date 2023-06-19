package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Resultados;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultados, Long> {
    Page<Resultados> findByIdContaining(Long idPartida, Pageable paginacao);
}
