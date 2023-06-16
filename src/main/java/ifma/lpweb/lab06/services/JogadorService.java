package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.repositories.JogadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogadorService{
    private final JogadorRepository jogadorRepository;
    @Autowired
    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }

    @Transactional
    public Object cadastrar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> buscarPorId(Long id) {
        return jogadorRepository.findById(id);
    }

    @Transactional
    public Jogador atualizar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @Transactional
    public void deletar(Long id) {
        jogadorRepository.deleteById(id);
    }

    public Iterable<Jogador> listar() {
        return jogadorRepository.findAll();
    }

    public Iterable<Jogador> listarPaginado(Integer numeroPagina, Integer quantidadePagina) {
        return jogadorRepository.findAll();
    }

    public Page<Jogador> listarPaginado(Pageable paginacao) {
        return jogadorRepository.findAll(paginacao);
    }

    public Page<Jogador> listarPorNome(String nome, Pageable paginacao) {
        return jogadorRepository.findByNomeContaining(nome, paginacao);
    }

    public boolean naoExisteJogadorCom(Long id) {
        return !jogadorRepository.existsById(id);
    }
}
