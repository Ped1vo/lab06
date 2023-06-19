package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.models.Estadio;
import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.repositories.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadioService {
    private final EstadioRepository estadioRepository;

    @Autowired
    public EstadioService(EstadioRepository estadioRepository){
        this.estadioRepository = estadioRepository;
    }

    public Object cadastrar(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public Optional<Estadio> buscarPorId(Long id) {
        return estadioRepository.findById(id);
    }

    public boolean naoExisteEstadioCom(Long id) {
        return !estadioRepository.existsById(id);
    }

    public Estadio atualizar(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public void deletar(Long id) {
        estadioRepository.deleteById(id);
    }

    public Iterable<Estadio> listar() {
        return estadioRepository.findAll();
    }

    public Iterable<Estadio> listarPaginado(PageRequest paginacao) {
        return estadioRepository.findAll(paginacao);
    }

    public Page<Estadio> listarPorNome(String nome, Pageable paginacao) {
        return estadioRepository.findByNomeContaining(nome, paginacao);
    }

    public Page<Estadio> listarPaginado(Pageable paginacao) {
        return estadioRepository.findAll(paginacao);
    }
}
