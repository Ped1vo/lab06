package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.models.Campeonato;
import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.repositories.CampeonatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampeonatoService {
    private final CampeonatoRepository campeonatoRepository;

    @Autowired
    public CampeonatoService(CampeonatoRepository campeonatoRepository){
        this.campeonatoRepository = campeonatoRepository;
    }
    @Transactional
    public Object cadastrar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public Optional<Campeonato> buscarPorId(Long id) {
        return campeonatoRepository.findById(id);
    }

    @Transactional
    public Campeonato atualizar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    @Transactional
    public void deletar(Long id) {
        campeonatoRepository.deleteById(id);
    }

    public Iterable<Campeonato> listar() {
        return campeonatoRepository.findAll();
    }

    public Iterable<Campeonato> listarPaginado(Integer numeroPagina, Integer quantidadePagina) {
        return campeonatoRepository.findAll();
    }

    public Page<Campeonato> listarPaginado(Pageable paginacao) {
        return campeonatoRepository.findAll(paginacao);
    }

    public Page<Campeonato> listarPorNome(String nome, Pageable paginacao) {
        return campeonatoRepository.findByNomeContaining(nome, paginacao);
    }

    public boolean naoExisteCampeonatoCom(Long id) {
        return !campeonatoRepository.existsById(id);
    }
}
