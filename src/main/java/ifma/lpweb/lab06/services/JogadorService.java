package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.mapper.JogadorMapper;
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
    private JogadorMapper jogadorMapper;
    @Autowired
    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }

    @Transactional
    public Jogador cadastrar(Jogador jogador) {
        // lógica de cadastro do jogador
        Jogador jogadorSalvo = jogadorRepository.save(jogador);
        return jogadorSalvo;
    }

    public Jogador buscarPorId(Long id) {
        // lógica de busca do jogador por id
        Optional<Jogador> jogadorOptional = jogadorRepository.findById(id);
        return jogadorOptional.orElse(null);
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

    public Page<Jogador> listarPaginado(Pageable paginacao) {
        return jogadorRepository.findAll(paginacao);
    }

    public Page<Jogador> listarPorNome(String nome, Pageable paginacao) {
        return jogadorRepository.findByNomeContaining(nome, paginacao);
    }

    public boolean naoExisteJogadorCom(Long id) {
        return !jogadorRepository.existsById(id);
    }


    public void delete(Long id) {
        jogadorRepository.deleteById(id);
    }
}
