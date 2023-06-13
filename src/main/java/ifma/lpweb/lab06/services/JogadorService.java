package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService{
    private final JogadorRepository jogadorRepository;
    @Autowired
    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }

}
