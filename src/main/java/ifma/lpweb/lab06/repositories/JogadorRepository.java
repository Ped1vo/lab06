package ifma.lpweb.lab06.repositories;

import ifma.lpweb.lab06.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
    Optional<Jogador> findById(UUID idJogador);
}
