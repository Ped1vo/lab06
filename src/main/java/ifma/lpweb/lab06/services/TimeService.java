package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Time;
import ifma.lpweb.lab06.repositories.TimeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {
    private final TimeRepository timeRepository;
    @Autowired
    public TimeService(TimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }

    @Transactional
    public Object cadastrar(Time time) {
        return timeRepository.save(time);
    }

    public Optional<Time> buscarPorId(Long id) {
        return timeRepository.findById(id);
    }

    @Transactional
    public Time atualizar(Time time) {
        return timeRepository.save(time);
    }

    @Transactional
    public void deletar(Long id) {
        timeRepository.deleteById(id);
    }

    public Iterable<Time> listar() {
        return timeRepository.findAll();
    }

    public Iterable<Time> listarPaginado(Integer numeroPagina, Integer quantidadePagina) {
        return timeRepository.findAll();
    }

    public Page<Time> listarPaginado(Pageable paginacao) {
        return timeRepository.findAll(paginacao);
    }

    public Page<Time> listarPorNome(String nome, Pageable paginacao) {
        return timeRepository.findByNomeContaining(nome, paginacao);
    }

    public boolean naoExisteTimeCom(Long id) {
        return !timeRepository.existsById(id);
    }

    public List<Time> findByCampeonatoId(Long campeonatoId) {
        return timeRepository.findByCampeonatoId(campeonatoId);
    }

}
