package ifma.lpweb.lab06.services;


import ifma.lpweb.lab06.models.Partida;
import ifma.lpweb.lab06.models.Resultados;
import ifma.lpweb.lab06.repositories.PartidaRepository;
import ifma.lpweb.lab06.repositories.ResultadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultadoService {
    private final ResultadoRepository resultadoRepository;

    @Autowired
    public ResultadoService(ResultadoRepository resultadoRepository){
        this.resultadoRepository = resultadoRepository;
    }
    @Transactional
    public Object cadastrar(Resultados resultados) {
        return resultadoRepository.save(resultados);
    }

    public Optional<Resultados> buscarPorId(Long id) {
        return resultadoRepository.findById(id);
    }

    @Transactional
    public Resultados atualizar(Resultados resultados) {
        return resultadoRepository.save(resultados);
    }

    @Transactional
    public void deletar(Long id) {
        resultadoRepository.deleteById(id);
    }

    public Iterable<Resultados> listar() {
        return resultadoRepository.findAll();
    }

    public Iterable<Resultados> listarPaginado(Integer numeroPagina, Integer quantidadePagina) {
        return resultadoRepository.findAll();
    }

    public Page<Resultados> listarPaginado(Pageable paginacao) {
        return resultadoRepository.findAll(paginacao);
    }

    public Page<Resultados> listarPorId(Long idResultado, Pageable paginacao) {
        return resultadoRepository.findByIdContaining(idResultado, paginacao);
    }

    public boolean naoExisteResultadoCom(Long id) {
        return !resultadoRepository.existsById(id);
    }


}