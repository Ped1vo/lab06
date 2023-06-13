package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, UUID> {
}
