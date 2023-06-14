package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JogadorService{
    private final JogadorRepository jogadorRepository;
    @Autowired
    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }

    public Object cadastrar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> buscarPorId(UUID idJogador) {
        return jogadorRepository.findById(idJogador);
    }
}
