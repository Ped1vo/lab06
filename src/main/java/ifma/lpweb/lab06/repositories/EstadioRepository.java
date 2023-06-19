package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Estadio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long> {
    Optional<Estadio> findById(Long idEstadio);

    Page<Estadio> findByNomeContaining(String nome, Pageable paginacao);
}
