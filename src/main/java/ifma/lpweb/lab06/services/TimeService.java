package ifma.lpweb.lab06.services;


import ifma.lpweb.lab06.models.Time;
import ifma.lpweb.lab06.repositories.TimeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
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

    public List<Time> listar() {
        return timeRepository.findAll();
    }

    public boolean existeTimeCom(Long id) {
        return timeRepository.existsById(id);
    }

    public List<Time> findByCampeonatoId(Long campeonatoId) {
        return timeRepository.findByCampeonatoId(campeonatoId);
    }
}
