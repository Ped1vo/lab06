package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}
