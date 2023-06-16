package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Partida;
import ifma.lpweb.lab06.repositories.PartidaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartidaService {
    private final PartidaRepository partidaRepository;
    @Autowired
    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @Transactional
    public Object cadastrar(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Optional<Partida> buscarPorId(Long id) {
        return partidaRepository.findById(id);
    }

    @Transactional
    public Partida atualizar(Partida partida) {
        return partidaRepository.save(partida);
    }

    @Transactional
    public void deletar(Long id) {
        partidaRepository.deleteById(id);
    }

    public Iterable<Partida> listar() {
        return partidaRepository.findAll();
    }

    public Iterable<Partida> listarPaginado(Integer numeroPagina, Integer quantidadePagina) {
        return partidaRepository.findAll();
    }

    public Page<Partida> listarPaginado(Pageable paginacao) {
        return partidaRepository.findAll(paginacao);
    }

    public Page<Partida> listarPorId(Long idPartida, Pageable paginacao) {
        return partidaRepository.findByIdContaining(idPartida, paginacao);
    }

    public boolean naoExistePartidaCom(Long id) {
        return !partidaRepository.existsById(id);
    }

}
